package com.wingle.hello.oo.sigleton;

public class SingletonByInnerClass {
    private static class SingletonHolder {
        private static final SingletonByInnerClass instance = new SingletonByInnerClass();
    }

    public static final SingletonByInnerClass Singleton() {
        return SingletonHolder.instance;
    }

    private SingletonByInnerClass() {
        System.out.println("SingletonByInnerClass init");
    }

}
