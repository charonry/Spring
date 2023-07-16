package com.init.spring_2.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class LoggingAspect {

    // @Before("execution(public int com.init.spring_2.aop.impl.ArtithmeticCalculator.add(int,int))")
    @Before("execution( * com.init.spring_2.aop.impl.ArtithmeticCalculator.*(*,*))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method：" + methodName + " begin with" + args);
    }

    @After("execution( * com.init.spring_2.aop.impl.ArtithmeticCalculator.*(*,*))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method：" + methodName + " ends");
    }
}
