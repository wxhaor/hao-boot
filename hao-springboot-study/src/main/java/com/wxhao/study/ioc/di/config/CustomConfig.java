package com.wxhao.study.ioc.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author wxhao
 * @date 2018/12/7
 */
@Configuration
public class CustomConfig {

    @Bean("configName")
    // 配置条件满足 ConfigNamePropertiesConditional 的验证
    @Conditional(ConfigNamePropertiesConditional.class)
    public String getCustomConfigProperties(CustomConfigProperties customConfigProperties){
        return customConfigProperties.getName();
    }

}
