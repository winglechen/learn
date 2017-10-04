package com.wingle.hello.parallel;

public class ReorderExample {

    int a = 0;
    boolean flag = false;

    public synchronized void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if(flag) {
            int i = a * a;
            System.out.println("the result is : " + i);
        }
    }
}
