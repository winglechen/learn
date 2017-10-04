package com.wingle.hello.thread.base;

import com.wingle.hello.thread.util.SleepUtil;

public class Interrupted {

    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepRunner");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "BusyRunner");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        SleepUtil.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleep thread state: " + sleepThread.isInterrupted());
        System.out.println("busy thread state: " + busyThread.isInterrupted());

        SleepUtil.sleep(5);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtil.sleep(1);
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                //doing nothing
            }
        }
    }
}
