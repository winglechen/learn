package com.wingle.hello.parallel;

public class VolatileFeatureExample {
    volatile long v1 = 0L;

    public void set(long l) {
        v1 = l;
    }

    public long getAndIncrement() {
        v1++;
        return v1;
    }

    public long getV1() {
        return v1;
    }
}
