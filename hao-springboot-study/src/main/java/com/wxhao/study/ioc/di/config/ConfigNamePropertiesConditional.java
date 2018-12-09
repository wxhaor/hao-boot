package com.wxhao.study.ioc.di.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author wxhao
 * @date 2018/12/7
 */
public class ConfigNamePropertiesConditional implements Condition {
    /**
     * 装配条件
     * @param context 条件上下文
     * @param metadata 注释类型的元数据
     * @return true 否则不装配
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Environment env = context.getEnvironment();
        //判断是否已经配置了对应的信息
        return env.containsProperty("config.name");
    }
}
