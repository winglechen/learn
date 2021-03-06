package com.wingle.hello.world;

/**
 * Created by winglechen on 2017/9/5.
 */
class Automoblie {}
class Car{}

public class Holder<T> {
    private T a;

    public Holder(T a) {
        this.a = a;
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }



    public static void main(String[] args) {
        Holder<Automoblie> h = new Holder<Automoblie>(new Automoblie());
        Automoblie a = h.get();
        System.out.println("Automobile: " + a);

        Holder<Car> h1 = new Holder<Car>(new Car());
        Car c = h1.get();
        System.out.println("Car: " + c);
    }
}




