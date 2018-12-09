package com.wxhao.study.aop.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wxhao
 * @date 2018/12/9
 */
@Aspect
public class MyAspect {

    //execution 标识在执行的时候,拦截里面的正则匹配的方法 * 标识任意返回类型的方法
    //(..) 标识匹配任意参数
    @Pointcut("execution(* com.wxhao.study.aop.spring.UserServiceImpl.printUser(..))")
    public void pointcut() {

    }

    //前置方法 , 固体看custom包 的约定流程
    @Before("pointcut()")
    public void before() {
        System.out.println("before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around-before");
        //回调原有方法
        joinPoint.proceed();
        System.out.println("around-after");
    }

}

@Configuration
class Config {

    @Bean
    public MyAspect myAspect(){
        return new MyAspect();
    }

}
