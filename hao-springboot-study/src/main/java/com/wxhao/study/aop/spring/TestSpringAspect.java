package com.wxhao.study.aop.spring;

import com.wxhao.study.TestStudyApplication;
import com.wxhao.study.aop.custom.HelloService;
import com.wxhao.study.aop.custom.HelloServiceImpl;
import com.wxhao.study.aop.custom.MyInterceptor;
import com.wxhao.study.aop.custom.ProxyBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wxhao
 * @date 2018/12/8
 */
public class TestSpringAspect extends TestStudyApplication {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.printUser();
    }

//    around-before
//    before 实际结果 ,期望结果before应该第一个,所以around慎用
//    printUser
//    around-after
//    after
//    afterReturning

}
