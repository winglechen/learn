package com.wingle.hello.parallel;

public class VolatileLikeExample {
    long v1 = 0L;

    public synchronized void setV1(long l) {
        v1 = l;
    }

    public long getV1() {
        return v1;
    }

    public synchronized long getAndIncrement() {
        long temp = getV1();
        temp += 1L;
        setV1(temp);

        return v1;
    }
}
