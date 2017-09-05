package com.wingle.hello;

/**
 * Created by winglechen on 2017/9/5.
 */
public class VarArgs {
    public static void printArray(Object[] args) {
        for(Object obj: args){
            System.out.println(obj + " ");
        }
    }

    public static void main(String[] args) {
        Object objs[] = {
                new Integer(3), new Float(4.3), new StringBuffer("I am wingle")
        };
        printArray(objs);

        String strs[] = {"one", "two", "three"};
        printArray(strs);
    }
}
