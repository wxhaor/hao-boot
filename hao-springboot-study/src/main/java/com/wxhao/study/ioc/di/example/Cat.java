package com.wxhao.study.ioc.di.example;

/**
 * @author wxhao
 * @date 2018/12/6
 */
//@Component
public class Cat implements Animal {

    @Override
    public void use() {
        System.out.println("猫 " + Cat.class.getSimpleName() + " 是看门的");
    }
}
