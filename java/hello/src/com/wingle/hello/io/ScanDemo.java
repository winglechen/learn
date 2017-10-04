package com.wingle.hello.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanDemo {
    public static void main(String[] args) throws IOException {
        Scanner s = null;

        try {
            s = new Scanner(
                    new BufferedReader(
                            new FileReader("/code/tmp/in.txt")
                    ));

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            IOCloser.close(s);
        }
    }
}
