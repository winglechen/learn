package com.wingle.hello.annotaion;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Author {
    String name();
    String group();
}
