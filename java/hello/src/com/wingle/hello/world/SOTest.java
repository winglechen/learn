package com.wingle.hello.world;

import java.io.Serializable;

public class SOTest implements Serializable {
    private int witdh;
    private int height;

    public int getWitdh() {
        return witdh;
    }

    public void setWitdh(int witdh) {
        this.witdh = witdh;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void main(String[] args) {
        SOTest obj = new SOTest();
        obj.setHeight(5);
        obj.setWitdh(10);

        System.out.println(obj);
    }
}
