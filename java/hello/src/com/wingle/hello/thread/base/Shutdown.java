package com.wingle.hello.thread.base;

import com.wingle.hello.thread.util.SleepUtil;

public class Shutdown {

    public static void main(String[] args) throws Exception {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "count-thread-1");
        countThread.start();

        SleepUtil.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two, "count-thread-2");
        countThread.start();

        SleepUtil.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable {

        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }

            System.out.println("counter i= " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
