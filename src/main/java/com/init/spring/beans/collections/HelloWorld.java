package com.init.spring.beans.collections;

public class HelloWorld {

    private String name;

    public HelloWorld() {
        System.out.println("HelloWorld's constructor...");
    }

    public void setNameTest(String name) {
        this.name = name;
    }

    public HelloWorld(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("Hello: " + name);
    }

}
