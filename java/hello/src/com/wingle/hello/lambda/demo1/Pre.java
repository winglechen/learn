package com.wingle.hello.lambda.demo1;

public class Pre {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am a task running in a single thread");
            }
        };
        new Thread(task).start();
    }
}
