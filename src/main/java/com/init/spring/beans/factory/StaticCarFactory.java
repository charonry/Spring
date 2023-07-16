package com.init.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法:直接调用某一个类的静态方法就可以返回Bean的实例
 */
public class StaticCarFactory {

    private static Map<String, Car> cars = new HashMap<>();

    static {
        cars.put("Audo", new Car("Audo", 3000.0));
        cars.put("Ford", new Car("Ford", 4000.0));
    }

    public static Car getCar(String name) {
        return cars.get(name);
    }
}
