package com.wingle.hello.oo.obj;

public class Main {
    public static void main(String[] args) {
        cloneDemo();
    }

    public static void cloneDemo() {
        CloneDemo demo1 = new CloneDemo();
        demo1.setCode(10);
        CloneDemo demo2 = demo1.clone();

        System.out.println("equals : " + demo1.equals(demo2));
        System.out.println("demo1.hashCode: " + demo1.hashCode());
        System.out.println("demo2.hashCode: " + demo2.hashCode());
        System.out.println("= test : " + (demo1 == demo2) );

        System.out.println("************************************************");
        System.out.println("demo1.code= " + demo1.getCode());
        System.out.println("demo2.code= " + demo2.getCode());

        demo2.setCode(20);

        System.out.println("************************************************");
        System.out.println("demo1.code= " + demo1.getCode());
        System.out.println("demo2.code= " + demo2.getCode());

    }
}
