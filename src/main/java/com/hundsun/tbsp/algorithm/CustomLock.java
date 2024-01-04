package com.hundsun.tbsp.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/11/22 16:30
 */
@Slf4j
public class CustomLock implements Lock {

    class MyAqs extends AbstractQueuedSynchronizer {
        /**
         * 尝试获取锁
         *
         * @param arg the acquire argument. This value is always the one
         *            passed to an acquire method, or is the value saved on entry
         *            to a condition wait.  The value is otherwise uninterpreted
         *            and can represent anything you like.
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            Thread current = Thread.currentThread();
            int state = getState();
            if (state == 0) {
                if (compareAndSetState(0, 1)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            } else if (state != 0) {
                if (state < 0) {
                    throw new IllegalMonitorStateException();
                }
                if (current == getExclusiveOwnerThread()) {
                    state += arg;
                    setState(state);
                    return true;
                }
            }
            return false;
        }

        /**
         * 释放锁
         *
         * @param arg the release argument. This value is always the one
         *            passed to a release method, or the current state value upon
         *            entry to a condition wait.  The value is otherwise
         *            uninterpreted and can represent anything you like.
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            Thread currentThread = Thread.currentThread();
            if (currentThread != getExclusiveOwnerThread()) {
                throw new IllegalMonitorStateException();
            }
            int state = getState() - arg;
            boolean flag = false;
            if (state == 0) {
                flag = true;
                setExclusiveOwnerThread(null);
            }
            setState(state);
            return flag;
        }

        @Override
        protected boolean isHeldExclusively() {
            return Thread.currentThread() == getExclusiveOwnerThread();
        }

        protected Condition newCondition() {
            return new ConditionObject();
        }
    }

    private MyAqs asyc = new MyAqs();


    @Override
    public void lock() {
        asyc.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        asyc.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {

        return asyc.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return asyc.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        asyc.release(1);
    }

    @Override
    public Condition newCondition() {
        return asyc.newCondition();
    }
}
