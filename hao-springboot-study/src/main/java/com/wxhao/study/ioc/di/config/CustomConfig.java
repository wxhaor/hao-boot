package com.wxhao.study.ioc.di.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * @author wxhao
 * @date 2018/12/6
 */
@Component
//@ConfigurationProperties("config")
@Data

public class CustomConfig {

@Value("${config.name}")
    private String name;

    private String value;

}
