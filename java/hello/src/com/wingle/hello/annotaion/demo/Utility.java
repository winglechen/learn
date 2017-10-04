package com.wingle.hello.annotaion.demo;

import com.wingle.hello.annotaion.Author;
import com.wingle.hello.annotaion.Description;

@Description(value = "This is a util class")
public class Utility {

    @Author(name="wingle", group="com.wingle")
    public String work() {
       return "work over!";
    }
}
