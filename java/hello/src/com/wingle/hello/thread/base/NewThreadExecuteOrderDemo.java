package com.wingle.hello.thread.base;

public class NewThreadExecuteOrderDemo extends Thread {

    @Override
    public void run() {
        System.out.println("test thread run");
    }

    public void step1() {
        System.out.println("test thread: step1");
    }

    public static void main(String[] args) {
        NewThreadExecuteOrderDemo t = new NewThreadExecuteOrderDemo();

        t.start();
        t.step1();

        System.out.println("main thread: running...");
    }
}
