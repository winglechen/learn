package com.wingle.hello.thread.base;

public class SleepInterrupt implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("sleep thread is about to sleep 2s");
            Thread.sleep(2000);
            System.out.println("sleep thread wake up");
        } catch (InterruptedException e) {
            System.out.println("sleep thread catch exception");
            return;
        }

        System.out.println("sleep thread end");
    }

    public static void main(String[] args) {
        SleepInterrupt sleepInterrupt = new SleepInterrupt();
        Thread t = new Thread(sleepInterrupt);
        t.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("main thread cache exception");
        }

        System.out.println("main thread interrupte sleep thread");
        t.interrupt();

        System.out.println("main thread end");
    }
}
