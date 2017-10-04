package com.wingle.core.lang;

public interface Context {
    Factory factory = null;

    Context parent();
    void setFactory(Factory factory);

    Object get(String className);
    Boolean set(String className, Object object);
    Boolean recyle(Object o);
}
