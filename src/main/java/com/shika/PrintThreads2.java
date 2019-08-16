package com.shika;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 三个线程轮流打印A，B，C
 * 使用synchronized
 */
public class PrintThreads2 {
    private final static Object object = new Object();
    private static int cnt = 0;

    public static class Print1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                synchronized (object) {
                    try {
                        while (cnt % 3 != 0) {
                            object.wait();
                        }
                        System.out.println(Thread.currentThread().getName() + ": A");
                        cnt++;
                        object.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class Print2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                synchronized (object) {
                    try {
                        while (cnt % 3 != 1) {
                            object.wait();
                        }
                        System.out.println(Thread.currentThread().getName() + ": B");
                        cnt++;
                        object.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class Print3 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                synchronized (object) {
                    try {
                        while (cnt % 3 != 2) {
                            object.wait();
                        }
                        System.out.println(Thread.currentThread().getName() + ": C");
                        cnt++;
                        object.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
