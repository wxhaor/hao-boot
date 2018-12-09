package com.wxhao.study.aop.custom;


import java.lang.reflect.InvocationTargetException;

/**
 * 拦截器接口
 * @author wxhao
 * @date 2018/12/7
 */
public interface Interceptor {

    //事前方法
    boolean before();

    //事后方法
    void after();

    /**
     * 取代原有时间方法
     * @param invocation 回调参数,可以通过他的peoceed 方法 回调原有时间
     * @return 返回原有时间返回对象
     */
    Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException ;

    //是否返回方法,事件没有发生异常执行
    void afterReturning();

    //事后异常方法,当时间发生异常执行
    void afterThrowing();

    //是否使用 around 方法取代原有方法
    boolean useAround();

}
