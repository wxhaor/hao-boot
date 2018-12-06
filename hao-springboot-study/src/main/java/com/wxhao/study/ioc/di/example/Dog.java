package com.wxhao.study.ioc.di.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author wxhao
 * @date 2018/12/6
 */
@Component
//如果有歧义性,则优先
@Primary
public class Dog implements Animal {

    @Override
    public void use() {
        System.out.println("狗 " + Dog.class.getSimpleName() + " 是看门的");
    }
}
