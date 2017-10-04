package com.wingle.hello.oo.sigleton;

public class SingletonBySynchronize {
    private static volatile SingletonBySynchronize instance;
    private static int i=0;

    public static SingletonBySynchronize Singleton() {
        if(null != instance) {
            return instance;
        }

        init: synchronized (SingletonBySynchronize.class) {
            if(null != instance) {
                break init;
            }

            i++;
            System.out.println("thread operating and counter= " + i);
            instance = new SingletonBySynchronize();
        }

        return instance;
    }

    private SingletonBySynchronize() {
        System.out.println("Singleton SingletonBySynchronize was init");
    }

}
