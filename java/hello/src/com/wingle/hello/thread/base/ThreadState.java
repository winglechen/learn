package com.wingle.hello.thread.base;

import com.wingle.hello.thread.util.SleepUtil;
import com.wingle.hello.thread.util.ThreadMonitor;

public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "time-waiting").start();
        new Thread(new Waiting(), "waiting1").start();
        new Thread(new Waiting(), "waiting2").start();
        new Thread(new Blocked(), "block1").start();
        new Thread(new Blocked(), "block2").start();

        ThreadMonitor.list();
    }

    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtil.sleep(5);
            }
        }
    }

    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtil.sleep(10);
                }
            }
        }
    }

}
