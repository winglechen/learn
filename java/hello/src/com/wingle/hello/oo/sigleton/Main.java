package com.wingle.hello.oo.sigleton;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class Main {
    public static void main(String[] args) {
        Runnable job = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread start ...");
                getInstances();
            }

            private void getInstances() {
                for(int i=0; i<10; i++) {
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    System.out.println("instance loop: " + i);
                    SingletonBySynchronize.Singleton();
                    SingletonByStaticVar.Singleton();
                    SingletonByInnerClass.Singleton();
                    SingletonByEnum.Singleton();
                }
            }
        };

        new Thread(job).start();
        new Thread(job).start();
        new Thread(job).start();
        new Thread(job).start();
        new Thread(job).start();


        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId()+ "] " + threadInfo.getThreadName());
        }
    }
}
