package com.wingle.hello.lambda.demo1;

public class Current {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("In java8: Am I cool?");
        new Thread(task).start();
    }
}
