package com.wingle.hello.thread.future;

import com.wingle.hello.thread.util.SleepUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Hello {

    private static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            SleepUtil.sleep(2);

            String tid = String.valueOf(Thread.currentThread().getId());
            System.out.println("Thread#" + tid + " : is calling...");

            return "threadid: " + tid;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> results = new ArrayList<Future<String>>();
        ExecutorService es = Executors.newCachedThreadPool();

        for(int i=0; i<100; i++) {
            Future<String> result = es.submit(new Task());
            results.add(result);
        }

        for(Future<String> result : results) {
            System.out.println("get result: " + result.get());
        }
    }
}
