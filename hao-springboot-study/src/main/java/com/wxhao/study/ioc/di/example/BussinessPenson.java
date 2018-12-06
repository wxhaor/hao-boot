package com.wxhao.study.ioc.di.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author wxhao
 * @date 2018/12/6
 */
@Component
public class BussinessPenson implements Penson {


    @Autowired //根据类型注入 , 必须找到对应Bean , 如果不能确定存在且允许为空 则 @Autowired(required = false)
    @Qualifier("dog") //避免歧义 通过type 和beanName获取
    private Animal animal = null;
//    @Autowired    //先根据type,如果不唯一,则根据bean名称匹配,如果还匹配不到则抛异常
//    private Animal dog = null;


    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
