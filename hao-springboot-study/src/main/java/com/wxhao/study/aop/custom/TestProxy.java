package com.wxhao.study.aop.custom;

import org.junit.Test;

/**
 * @author wxhao
 * @date 2018/12/8
 */
public class TestProxy {

    @Test
    public void test() {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("lyy");
    }

}
