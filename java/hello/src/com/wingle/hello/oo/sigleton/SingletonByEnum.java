package com.wingle.hello.oo.sigleton;

public enum SingletonByEnum {
    INSTANCE;

    public static SingletonByEnum Singleton() {
        return INSTANCE;
    }

    private SingletonByEnum() {
        System.out.println("SingletonByEnum init");
    }
}
