package com.init.spring.beans.collections;

public class Car {
    private String branch;
    private double price;
    private double speed;

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getBranch() {
        return branch;
    }

    public double getPrice() {
        return price;
    }

    public double getSpeed() {
        return speed;
    }

    public Car() {
    }

    public Car(String branch, double price, double speed) {
        this.branch = branch;
        this.price = price;
        this.speed = speed;
    }

    public Car(double price, String branch, double speed) {
        this.branch = branch;
        this.price = price;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "branch='" + branch + '\'' +
                ", price=" + price +
                ", speed='" + speed + '\'' +
                '}';
    }


}
