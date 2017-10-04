package com.wingle.hello.thread.util;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadMonitor {
    public static void list() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);

        System.out.println("[thread-id]     [thread-state]   [thread-name]");
        for(ThreadInfo threadInfo : threadInfos) {
            System.out.print("[" + threadInfo.getThreadId() + "]     ");
            System.out.print("" + threadInfo.getThreadState() + "     ");
            System.out.print("" + threadInfo.getThreadName() + "     ");
            System.out.println("");
        }
    }
}
