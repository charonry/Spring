package com.init.spring_2.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

public class ArtithmeticCalculatorLoggingProxy {

    private ArtithmeticCalculator target;

    public ArtithmeticCalculatorLoggingProxy(ArtithmeticCalculator target) {
        this.target = target;
    }

    public ArtithmeticCalculator getLoggingProxy() {
        ArtithmeticCalculator proxy = null;
        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型，即有哪些方法
        Class[] interfaces = new Class[]{ArtithmeticCalculator.class};
        //当调用代理对象方法，该执行的代码
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * @param proxy:正在返回的那个代理对象，一般情况在invoke都不怎么使用该对象(会导致内存溢出)
             * @param method:正在被调用的方法
             * @param args:调用方法是传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //日志
                System.out.println("The method：" + methodName + "\t" + "begin with" + "\t" + Arrays.asList(args));
                //执行方法
                Object result = null;
                try {
                    //前置通知
                    result = method.invoke(target, args);
                    //返回通知：可以返回到方法的返回值
                } catch (Exception e) {
                    e.printStackTrace();
                    //异常通知：可以访问到方法出现的异常
                }
                //后置通知：可能存在异常，所以访问不到返回值
                //日志
                System.out.println("The method：" + methodName + "\t" + "end with" + "\t" + result);
                return result;
            }
        };
        proxy = (ArtithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
        return proxy;
    }
}
