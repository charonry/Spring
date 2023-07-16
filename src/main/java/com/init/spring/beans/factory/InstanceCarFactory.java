package com.init.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * *实例工厂方法：创建工厂本身，在通过实例方法来返回Bean的实例
 */
public class InstanceCarFactory {

    private static Map<String, Car> cars = null;

    public InstanceCarFactory() {
        cars = new HashMap<>();
        cars.put("Audo", new Car("Audo", 3000.0));
        cars.put("Ford", new Car("Ford", 7000.0));
    }

    public Car getCar(String name) {
        return cars.get(name);
    }
}
