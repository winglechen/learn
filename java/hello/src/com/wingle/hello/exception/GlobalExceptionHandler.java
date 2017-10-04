package com.wingle.hello.exception;

import java.util.concurrent.atomic.AtomicInteger;

public class GlobalExceptionHandler {

    static class Handler implements Thread.UncaughtExceptionHandler {
        private static AtomicInteger counter = new AtomicInteger(0);

        public void uncaughtException(Thread t, Throwable e) {
            int currentCounter = counter.addAndGet(1);
            System.out.println("current counter: " + currentCounter);

            System.out.println("Thread id: " + t.getName());
            System.out.println("Throwable: " + e.getMessage());
        }
    }

    static class DemoThread implements Runnable {

        public void run() {
            throw new RuntimeException("throw from DemoThread");
        }
    }

    public static void main(String[] args) throws Exception {
        Handler handler = new Handler();
        Thread.setDefaultUncaughtExceptionHandler(handler);

        new Thread(new DemoThread(), "Demo Thread").start();

        throw new RuntimeException("Thrown from main");
    }
}
