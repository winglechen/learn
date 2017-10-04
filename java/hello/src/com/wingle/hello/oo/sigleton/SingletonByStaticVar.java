package com.wingle.hello.oo.sigleton;

public class SingletonByStaticVar {
    private static final SingletonByStaticVar instance = new SingletonByStaticVar();

    public static SingletonByStaticVar Singleton() {
        return instance;
    }

    private SingletonByStaticVar() {
        System.out.println("SingletonByStaticVar");
    }
}
