package com.wingle.hello.thread.base;

import com.wingle.hello.thread.util.SleepUtil;

public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "daemon-thread");
        thread.setDaemon(true);
        thread.start();

        System.out.println("end of the main thread");
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            System.out.println("DaemonRunner start running...");
            try {
                SleepUtil.sleep(5);
                System.out.println("DaemonRunner after sleep");
            } finally {
                System.out.println("daemonRunner finally executing..");
            }
        }
    }
}
