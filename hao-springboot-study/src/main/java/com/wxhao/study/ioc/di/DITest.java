package com.wxhao.study.ioc.di;

import com.wxhao.study.ioc.di.example.BussinessPenson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wxhao
 * @date 2018/12/6
 */
@Configuration
@ComponentScan
public class DITest {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DITest.class);
        BussinessPenson penson = ctx.getBean(BussinessPenson.class);
        penson.service();
    }

}
