package com.wingle.hello.world;

public class FinallyExample {
    public static void main(String[] args) {
        System.out.println("simpleTryCatch result: " + simpleTryCatch());
        System.out.println("finallyReturn result: " + finallyReturn());
        System.out.println("finallyReturn2 result: " + finallyReturn2());
        System.out.println("tryWithSystemExit result: " + tryWithSystemExit());
    }

    public static int simpleTryCatch() {
        try {
            System.out.println("simpleTryCatch.try block");
            return 1;
        } finally {
            System.out.println("simpleTryCatch.finally block");
        }
    }

    public static int tryWithSystemExit() {
        try {
            System.out.println("tryWithSystemExit.try block");
            System.exit(0);
            return 1;
        } finally {
            System.out.println("tryWithSystemExit.finally block");
        }
    }
    
    public static int finallyReturn() {
        try {
            return 1;
        } finally {
            return 0;
        }
    }

    public static int finallyReturn2() {
        int i = 1;
        try {
            return 1;
        } finally {
            i++;
        }
    }
}
