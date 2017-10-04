package com.wingle.hello.world.enumexample;

public class Main {

    public static void main(String[] args) {
        System.out.println(Base.ONE + " | " + Base.TWO);
        System.out.println("******************************************");

        Light1 light = Light1.RED;
        System.out.println("red.index: " + light.getIndex() + "; red.name: " + light.getName() + ";");
        System.out.println("******************************************");


        Light1.showTime();

    }
}
