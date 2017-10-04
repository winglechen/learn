package com.wingle.hello.thread.base;

import com.wingle.hello.thread.util.SleepUtil;

public class Join {

    public static void main(String[] args) throws Exception {
        Thread previous = Thread.currentThread();

        for(int i=0; i<10; i++) {
            Thread thread = new Thread(new Domino(previous, i), String.valueOf(i));
            thread.start();
            previous = thread;
        }

        SleepUtil.sleep(1);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    private static class Domino implements Runnable {
        private Thread thread;
        private int no = 0;

        public Domino(Thread thread, int no) {
            this.thread = thread;
            this.no = no;
        }

        @Override
        public void run() {
            System.out.println("Thread-" + no + " running...");
            try {
                thread.join();
                System.out.println("After Thread-" + no + " join()");
            } catch (InterruptedException e) {

            }

            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
