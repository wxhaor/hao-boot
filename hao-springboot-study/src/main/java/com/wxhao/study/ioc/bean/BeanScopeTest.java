package com.wxhao.study.ioc.bean;

import com.wxhao.study.TestStudyApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wxhao
 * @date 2018/12/7
 */
@Slf4j
@ComponentScan
public class BeanScopeTest extends TestStudyApplication {

    @Test
    public void scopeTest() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanScopeTest.class);
        BeanScope bean1 = ctx.getBean(BeanScope.class);
        BeanScope bean2 = ctx.getBean(BeanScope.class);
        log.info("bean1 == bean2:" + Boolean.toString(bean1 == bean2));
        log.info("bean1:" + bean1.getInitTime());
        log.info("bean2:" + bean2.getInitTime());
    }

}
