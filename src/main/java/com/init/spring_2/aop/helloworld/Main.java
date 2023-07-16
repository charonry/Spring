package com.init.spring_2.aop.helloworld;

public class Main {
    public static void main(String[] args) {
        ArtithmeticCalculator targrt = new ArtithmeticCalculatorImpl();
        ArtithmeticCalculator proxy = new ArtithmeticCalculatorLoggingProxy(targrt).getLoggingProxy();
        System.out.println(proxy.getClass().getName());
        int result = proxy.sub(1, 2);
        System.out.println("-->" + "\t" + result);
        result = proxy.div(4, 2);
        System.out.println("-->" + "\t" + result);
    }
}
