package com.wingle.hello.thread.local;

import com.wingle.hello.thread.util.SleepUtil;

public class Profiler {

    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };


    public static void main(String[] args) {
        Profiler.begin();
        SleepUtil.sleep(1);
        Long elapse = Profiler.end();

        System.out.println("rt: " + elapse + "ms.");
    }


    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }
}
