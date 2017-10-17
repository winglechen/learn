package com.wingle.hello.thread.pooling;

import java.util.concurrent.Executor;

public class DirectExecutor implements Executor {

    public static void main(String[] args) {
        DirectExecutor directExecutor = new DirectExecutor();
        directExecutor.execute(new DemoRunner());
    }

    @Override
    public void execute(Runnable r) {
        r.run();
    }

    private static class DemoRunner implements Runnable {

        @Override
        public void run() {
            System.out.println("I am demo-runner. Ha Ha.");
        }
    }

}
