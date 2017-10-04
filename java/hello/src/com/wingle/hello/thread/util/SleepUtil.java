package com.wingle.hello.thread.util;

import java.util.concurrent.TimeUnit;

public class SleepUtil {
    public static final void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            // doing nothing
        }
    }
}
