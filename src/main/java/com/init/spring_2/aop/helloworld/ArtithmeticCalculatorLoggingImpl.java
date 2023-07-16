package com.init.spring_2.aop.helloworld;

public class ArtithmeticCalculatorLoggingImpl implements ArtithmeticCalculator {
    @Override
    public int add(int i, int j) {
        System.out.println("The method add begins with[" + i + "," + j + "]");
        int result = i + j;
        System.out.println("The method add end with" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("The method sub begins with[" + i + "," + j + "]");
        int result = i - j;
        System.out.println("The method sub end with" + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("The method mul begins with[" + i + "," + j + "]");
        int result = i * j;
        System.out.println("The method mul end with" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("The method div begins with[" + i + "," + j + "]");
        int result = i / j;
        System.out.println("The method div end with" + result);
        return result;
    }
}
