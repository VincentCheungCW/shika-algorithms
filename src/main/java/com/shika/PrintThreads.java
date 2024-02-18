package com.shika;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程轮流打印A，B，C
 * 使用ReentrantLock、Condition
 * 使用了3个condition，当然也可以用一个condition使用signalAll()
 */
public class PrintThreads {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();
    private static int cnt = 0;

    public static class Print1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    if (cnt % 3 != 0) {
                        condition1.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": A");
                    cnt++;
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class Print2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    lock.lock();
                    if (cnt % 3 != 1) {
                        condition2.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": B");
                    cnt++;
                    condition3.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class Print3 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    lock.lock();
                    if (cnt % 3 != 2) {
                        condition3.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": C");
                    cnt++;
                    condition1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Print1());
        executorService.submit(new Print2());
        executorService.submit(new Print3());
        executorService.shutdown();
    }
}
