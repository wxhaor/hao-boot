package com.wxhao.study.aop.custom;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wxhao
 * @date 2018/12/8
 */
public class ProxyBean implements InvocationHandler {

    private Object target;
    private Interceptor interceptor;

    /**
     * 绑定代理对象
     *
     * @param target
     * @param interceptor
     * @return
     */
    public static Object getProxyBean(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();
        //保存被代理对象
        proxyBean.target = target;
        //保存拦截器
        proxyBean.interceptor = interceptor;

        //生成代理对象
        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader()
                //实现代理对象逻辑
                , target.getClass().getInterfaces(), proxyBean);

        return proxyInstance;
    }

    /**
     * 处理代理对象方法逻辑
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        boolean errorFlag = false;

        Invocation invocation = new Invocation(target, method, args);
        Object retObj = null;

        try {
            if (this.interceptor.before()) {
                retObj = this.interceptor.around(invocation);
            } else {
                retObj = method.invoke(target, args);

            }
        } catch (Exception e) {
            errorFlag = true;
        }
        this.interceptor.after();
        if (errorFlag) {
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
            return retObj;
        }

        return null;
    }
}
