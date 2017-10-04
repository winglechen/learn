package com.wingle.hello.lib.connectionpool;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) throws Exception {
        int count = 20, threadCount = 10;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        end = new CountDownLatch(threadCount);

        for (int i=0; i<threadCount; i++) {
            Thread thread = new Thread(
                    new ConnectionRunner(count, got, notGot),
                    "connection-runner"
            );
            thread.start();
        }

        start.countDown();
        end.await();

        System.out.println("total invoke: " + (threadCount + count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection: " + notGot);

    }

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count  = count;
            this.got    = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (Exception e) {

            }

            while (count > 0) {
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (null == connection) {
                        notGot.incrementAndGet();
                        continue;
                    }

                    try {
                        connection.createStatement();
                        connection.commit();
                    } finally {
                        pool.releaseConnection(connection);
                        got.incrementAndGet();
                    }
                } catch (Exception e) {

                } finally {
                    count--;
                }
            }

            end.countDown();
        }
    }
}
