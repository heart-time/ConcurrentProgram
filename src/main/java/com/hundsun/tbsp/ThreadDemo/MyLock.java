package com.hundsun.tbsp.ThreadDemo;

import com.hundsun.tbsp.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.ThreadDemo
 * @Description
 * @date 2023/11/21 21:49
 */
@Slf4j
public class MyLock {
    public static void main(String[] args) {
        MyLock2 lock = new MyLock2();
        new Thread(() -> {
            lock.lock();
            log.info("locking....");
            lock.lock();
            log.info("locking....");
            try {
                log.info("locking....");
                ThreadUtils.sleep(2);
            } finally {
                lock.unlock();
                log.info("unlocking....");
                lock.unlock();
                log.info("unlocking....");
            }

        }, "t1").start();
        new Thread(() -> {
            lock.lock();

            try {
                log.info("locking....");
            } finally {
                log.info("unlocking....");
                lock.unlock();
            }

        }, "t2").start();
    }

}

class MyLock2 implements Lock {
    class MyAqs extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            Thread currentThread = Thread.currentThread();
            int state = getState();
            if (state == 0) {
                if (compareAndSetState(0, 1)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            } else if (currentThread == getExclusiveOwnerThread()) {
                if(state < 0){
                    throw new IllegalStateException();
                }
                state += arg;
                setState(state);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
          Thread currentThread = Thread.currentThread();
          if(currentThread!=getExclusiveOwnerThread()){
              throw  new IllegalMonitorStateException();
          }
          int state = getState();
          state -= arg;
          boolean flag =false;
          if(state == 0){
              setExclusiveOwnerThread(null);
              flag =  true;
          }
          setState(state);
          return flag;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        protected Condition newCondition() {
            return new ConditionObject();
        }

    }

    private MyAqs myAqs = new MyAqs();

    /**
     * 加锁(不成功一直尝试加锁)
     */
    @Override
    public void lock() {
        myAqs.acquire(1);
    }

    /**
     * 加锁可以被打断
     *
     * @throws InterruptedException
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {
        myAqs.acquireInterruptibly(1);
    }

    /**
     * 尝试获取锁，只会获取一次
     *
     * @return
     */
    @Override
    public boolean tryLock() {
        return myAqs.tryAcquire(1);
    }

    /**
     * 尝试获取锁(有超时时间)
     *
     * @param time the maximum time to wait for the lock
     * @param unit the time unit of the {@code time} argument
     * @return
     * @throws InterruptedException
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        myAqs.tryAcquireNanos(1, unit.toNanos(time));
        return false;
    }

    /**
     * 解锁
     */
    @Override
    public void unlock() {
        myAqs.release(1);
    }

    /**
     * 创建条件变量
     *
     * @return
     */
    @Override
    public Condition newCondition() {
        return myAqs.newCondition();
    }
}
