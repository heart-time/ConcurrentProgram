package com.hundsun.tbsp.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.utils
 * @Description
 * @date 2023/11/19 13:38
 */
@Slf4j
public class ThreadPoolCustom2 {
    public static void main(String[] args) {
        ThreadPoolCustom threadPoolCustom = new ThreadPoolCustom(1, 1000, TimeUnit.MILLISECONDS, 1,(queue,task)->{
            //阻塞等待
//            queue.put(task);
           //有限等待
//            queue.offer(task,1,TimeUnit.SECONDS);
           //拒绝执行
//            log.info("拒绝加入任何任务");
           //抛出异常
//            throw new RuntimeException("超出了阻塞队列容量");

        });
        for (int i = 0; i < 3; i++) {
            int j = i;
            //lambda表达式中的变量不可变
            threadPoolCustom.execute(() -> {
                ThreadUtils.sleep(2);
                log.info("{}", j);
            });
        }
    }
}

/**
 * 自定义线程池
 */
@Slf4j
class ThreadPoolCustom {
    /**
     * 核心线程数
     */
    private int coreSize;

    /**
     * 超时时间
     */
    private long timeOut;
    /**
     * 时间单位
     */
    private TimeUnit unit;
    /**
     * 拒绝策略
     */
    private RejectPolicy<Runnable> rejectPolicy;

    /**
     * 线程集合
     */
    private HashSet<Worker> works = new HashSet();

    /**
     * 阻塞队列
     */
    private BlockedQueue<Runnable> blockedQueue;


    public ThreadPoolCustom(int coreSize, long timeOut, TimeUnit unit, int queueCapacity,RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeOut = timeOut;
        this.unit = unit;
        this.blockedQueue = new BlockedQueue<>(queueCapacity);
         this.rejectPolicy = rejectPolicy;
    }

    /**
     * 执行任务方法
     */
    public void execute(Runnable task) {
        synchronized (works) {
            //当前的执行的任务数小于coresize创建新的worker执行任务
            if (works.size() < coreSize) {
                Worker worker = new Worker(task);
                log.info("创建新的线程:{}", worker);
                works.add(worker);
                worker.start();
            } else {
                //无限等待
                blockedQueue.tryPut(rejectPolicy,task);
            }
        }
    }
     @FunctionalInterface
     interface RejectPolicy<T>{
        void handle(BlockedQueue<T> queue,T task);
     }

    /**
     * 线程
     */
    class Worker extends Thread {
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            //当前任务不为空
            while (task != null || (task = blockedQueue.poll(timeOut, unit)) != null) {
                try {
                    log.info("线程:{}执行任务:{}", this, task);
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    task = null;
                }
            }
            synchronized (works) {
                log.info("线程被移除:{}", this);
                works.remove(this);
            }
        }
    }
}

/**
 * 自定义的阻塞队列
 */
@Slf4j
class BlockedQueue<T> {
    //需要队列大小
    private int capacity;
    //阻塞队列
    private Deque<T> queue = new ArrayDeque();

    //锁
    private ReentrantLock lock = new ReentrantLock();
    //消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();
    //生产者条件变量
    private Condition fullWaitSet = lock.newCondition();

    public BlockedQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 获取队列元素(带超时时间)
     */
    public T poll(long timeOut, TimeUnit unit) {
        try {
            lock.lock();
            long nanos = unit.toNanos(timeOut);
            T t;
            while (queue.isEmpty()) {
                try {
                    if (nanos <= 0) {
                        return null;
                    }
                    nanos = emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    ;
                }
            }
            t = queue.pollFirst();
            fullWaitSet.signal();
            return t;
        } finally {
            lock.unlock();
            ;
        }
    }


    /**
     * 获取队列元素的方法
     */
    public T take() {
        try {
            lock.lock();
            T t;
            while (queue.isEmpty()) {
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            t = queue.pollFirst();
            fullWaitSet.signal();
            return t;
        } finally {
            lock.unlock();
            ;
        }
    }

    /**
     * 添加元素的方法
     *
     * @param task
     */


    public void put(T task) {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                try {
                    log.info("任务等待被放入阻塞队列:{}", task);
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("任务被放入阻塞队列:{}", task);
            queue.offer(task);
            fullWaitSet.signal();
        } finally {
            lock.unlock();
        }

    }


    /**
     * 待超时时间添加元素的方法
     *
     * @param task
     */
    public boolean offer(T task, long timeout, TimeUnit unit) {
        lock.lock();
        try {
            long nanos = unit.toNanos(timeout);
            while (queue.size() == capacity) {
                try {
                    log.info("任务等待被放入阻塞队列:{}", task);
                    if (nanos <= 0) {
                        log.info("加入阻塞队列失败");
                        return false;
                    }
                    nanos = fullWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("任务被放入阻塞队列:{}", task);
            queue.offer(task);
            fullWaitSet.signal();
            return true;
        } finally {
            lock.unlock();
        }

    }

    /**
     * 获取队列大小
     */
    public int getSize() {
        lock.lock();

        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    public void tryPut(ThreadPoolCustom.RejectPolicy<T> rejectPolicy,T task) {
        if(queue.size()<capacity){
            log.info("加入阻塞队列");
            put(task);
        }else {
            log.info("执行拒绝策略");
            rejectPolicy.handle(this,task);
        }
    }
}