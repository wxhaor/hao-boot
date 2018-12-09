package com.wxhao.study.ioc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author wxhao
 * @date 2018/12/7
 */
@Component
//不单例
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Data
public class BeanScope {

    //T()代表引入类
    @Value("#{T(java.lang.System).currentTimeMillis()}")
    private Long initTime;

    @Value("#{'赋值字符串abc'}")
    private String string;

    //赋值科学计数法
    @Value("#{9.3E3}")
    private Double aDouble;

    //赋值浮点数
    @Value("#{3.14}")
    private Float aFloat;

    //赋值其他bean(bean的名字)的属性
    @Value("#{beanScope.string}")
    private String beanProp;

    //调用其他bean属性的方法(toUpperCase示例方法) , ?的意思是判断是否为空,不为空才会执行方法
    @Value("#{beanScope.string?.toUpperCase()}")
    private String beanPropToUpCase;

    //还能进行基本计算 , 运算/比较/连接/三元运算

    //注解bean,可以装配不同环境
//    @Profile("dev")

}
