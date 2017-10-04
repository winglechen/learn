package com.wingle.hello.thread.base;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {

    public static void main(String[] args) throws Exception {
        PipedReader in = new PipedReader();
        PipedWriter out = new PipedWriter();

        out.connect(in);

        Thread printThread = new Thread(new Print(in), "print-thread");
        printThread.start();

        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }

    }


    private static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != 1) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {

            }
        }
    }

}
