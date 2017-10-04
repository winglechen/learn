package com.wingle.hello.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("/code/tmp/in.txt");
            out = new FileOutputStream("/code/tmp/out.txt", true);
            int c;

            while((c=in.read()) != -1) {
                out.write(c);
            }
        } finally {
            IOCloser.close(in, out);
        }
    }



}
