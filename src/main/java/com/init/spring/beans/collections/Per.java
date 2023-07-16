package com.init.spring.beans.collections;

public class Per {
    private String name;
    private int age;
    private Car car;

    public Per() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Per(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Per{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
