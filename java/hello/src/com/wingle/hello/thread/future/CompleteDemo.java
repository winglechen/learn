package com.wingle.hello.thread.future;

import java.util.concurrent.CompletableFuture;

public class CompleteDemo {

    public static void main(String[] args) {
        CompletableFuture<Double> futurePrice = getPriceAsnyc();

        System.out.println("after async method call");
        futurePrice.whenComplete(((aDouble, throwable) -> {
           System.out.println("get future result: " + aDouble);
        }));

        System.out.println("after get async result");
    }

    private static CompletableFuture<Double> getPriceAsnyc() {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            try {
                System.out.println("before thread sleep");
                Thread.sleep(3000);
                System.out.println("after thread sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            futurePrice.complete(23.55);
        }).start();

        return futurePrice;
    }
}
