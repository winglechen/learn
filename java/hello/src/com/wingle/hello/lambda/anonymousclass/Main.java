package com.wingle.hello.lambda.anonymousclass;

public class Main {
    public static void main(String[] args) {
        DemoInterface demo = new DemoInterface() {
            @Override
            public void showtime() {
                System.out.println("I am the instance of Demointerface, Ha Ha!");
            }
        };

        demo.showtime();
    }
}
