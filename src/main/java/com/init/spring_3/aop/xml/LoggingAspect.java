package com.init.spring_3.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

public class LoggingAspect {


    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method：" + methodName + " begin with" + args);
    }


    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method：" + methodName + " ends");
    }


    public void afterRunning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method：" + methodName + " end with" + "\t" + result);
    }


    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method：" + methodName + " occurs exception" + "\t" + ex);
    }

    /**
     * 环绕通知需要携带一个ProceedingJoinPoint的参数
     * 环绕通知类似于动态代理全过程：ProceedingJoinPoint可以决定是执行目标方法
     * 必须有返回值且返回值即目标方法的返回值
     *
     * @param proceedingJoinPoint
     */
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        //执行目标方法
        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(proceedingJoinPoint.getArgs());
        try {
            //前置通知
            System.out.println("The method：" + methodName + " begin with" + args);
            result = proceedingJoinPoint.proceed();
            //返回通知
            System.out.println("The method：" + methodName + " end with" + "\t" + result);
        } catch (Throwable e) {
            //异常通知
            System.out.println("The method：" + methodName + " occurs exception" + "\t" + e);
            e.printStackTrace();
        }
        //后置通知
        System.out.println("The method：" + methodName + " ends");
        return result;
    }
}
