package com.init.spring.beans.collections;


import java.util.Map;

public class NewPerson {
    private String name;
    private int age;
    private Map<String, Car> map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Car> getMap() {
        return map;
    }

    public void setMap(Map<String, Car> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "NewPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", map=" + map +
                '}';
    }
}
