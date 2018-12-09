package com.wxhao.study.aop.custom;


import java.lang.reflect.InvocationTargetException;

/**
 * 拦截器接口
 *
 * @author wxhao
 * @date 2018/12/7
 */
public class MyInterceptor implements Interceptor {


    @Override
    public boolean before() {
        System.out.println("before");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around-before");
        Object object = invocation.proceed();
        System.out.println("around-after");
        return object;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
