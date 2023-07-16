package com.init.spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization:" + bean + "\t" + beanName);
        if ("car1".equals(beanName)) {
            com.init.spring.beans.factory.Car car = new com.init.spring.beans.factory.Car();
            car.setBrand("CHINA");
            car.setPrice(2000);
            return car;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:" + bean + "\t" + beanName);
        com.init.spring.beans.factory.Car car = new com.init.spring.beans.factory.Car();
        car.setBrand("Jax");
        car.setPrice(1000);
        return car;
    }
}
