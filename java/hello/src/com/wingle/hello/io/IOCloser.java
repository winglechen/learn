package com.wingle.hello.io;

import java.io.Closeable;
import java.io.IOException;

public class IOCloser {

    public static void close(Closeable... fs){
        for(Closeable f : fs) {
            if (null == f) {
                continue;
            }

            try {
                f.close();
            } catch (IOException e) {
                System.out.println("close failed");
            }
        }
    }
}
