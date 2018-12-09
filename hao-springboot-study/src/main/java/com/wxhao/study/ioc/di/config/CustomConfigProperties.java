package com.wxhao.study.ioc.di.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @author wxhao
 * @date 2018/12/6
 */
@Component
@ConfigurationProperties("config")
@Data
public class CustomConfigProperties {


    private String name;

    private String value;

}
