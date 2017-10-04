package com.wingle.hello.lib.connectionpool;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if(initialSize <= 0) {
            return;
        }

        for(int i=0; i<initialSize; i++) {
            pool.addLast(ConnectionDriver.createConnection());
        }
    }

    public void releaseConnection(Connection connection) {
        if (null == connection) {
            return;
        }

        synchronized (pool) {
            pool.addLast(connection);
            pool.notifyAll();
        }
    }

    public Connection fetchConnection(long ms) throws InterruptedException {
        synchronized (pool) {

            if (ms <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }

                return pool.removeFirst();
            }

            long future = System.currentTimeMillis() + ms;
            long remailing = ms;

            while (pool.isEmpty() && remailing > 0) {
                //TODO: CHECK bugs
                pool.wait(remailing);
                remailing = future - System.currentTimeMillis();
            }

            Connection result = null;
            if (!pool.isEmpty()) {
                result = pool.removeFirst();
            }

            return result;
        }
    }
}
