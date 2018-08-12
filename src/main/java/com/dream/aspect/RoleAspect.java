package com.dream.aspect;

import org.aspectj.lang.annotation.*;

/**
 *
 */
@Aspect
public class RoleAspect {
    @Pointcut("execution(* com.dream.service.*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(){
        System.out.println("Before");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("After");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("After Returning...");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("After Throwing...");
    }
}
