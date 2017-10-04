package com.wingle.hello.annotaion.demo;

import com.wingle.hello.annotaion.Description;

import java.lang.reflect.Method;

public class UtilExec {
    public static void main(String[] args) {
        Class util = null;
        try {
           util = Class.forName("com.wingle.hello.annotaion.demo.Utility");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method[] methods = util.getMethods();
        boolean flag = util.isAnnotationPresent(Description.class);


    }
}
