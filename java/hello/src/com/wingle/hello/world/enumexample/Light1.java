package com.wingle.hello.world.enumexample;

public enum Light1 {
    RED("红色", 1),
    GREEN("绿色", 2),
    YELLOW("黄色", 3);

    private final String name;
    private final int index;

    private Light1(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public static void showTime(){
        for (Light1 l : Light1.values()) {
            System.out.println("index: " + l.getIndex() + "; name: " + l.getName() + ";");
        }
    }
}
