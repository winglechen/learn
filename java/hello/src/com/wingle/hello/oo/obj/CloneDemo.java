package com.wingle.hello.oo.obj;

public class CloneDemo implements Cloneable {
    private int code;
    public void showtime() {
        System.out.println("CloneDemo.showTime");
    }

    public CloneDemo clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return (CloneDemo)o;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
