package com.wingle.hello.thread.base;

public class JoinDemo implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("join-thread: runing: " + i);
        }
    }

    public static void main(String[] args) throws Exception {
        Runnable r = new JoinDemo();
        Thread t = new Thread(r);
        t.start();
        t.join();

        System.out.println("main thread running");
    }
}

