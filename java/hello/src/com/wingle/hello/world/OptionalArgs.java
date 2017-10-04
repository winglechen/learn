package com.wingle.hello.world;

/**
 * Created by winglechen on 2017/9/5.
 */
public class OptionalArgs {
    static void f(int required, String... trailing) {
        System.out.println("required: " + required);

        for(String str : trailing) {
            System.out.println("trailing : " + str);
        }
    }

    public static void main(String[] args) {
        f(0);
        f(1, "one");
        f(2, "one", "two");
    }
}
