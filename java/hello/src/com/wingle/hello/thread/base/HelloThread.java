package com.wingle.hello.thread.base;

public class HelloThread extends Thread {
    public void run() {
        System.out.println("Hello from a thread");
    }

    public static void main(String[] args) {
        new HelloThread().start();
        (new HelloThread()).start();
    }
}
