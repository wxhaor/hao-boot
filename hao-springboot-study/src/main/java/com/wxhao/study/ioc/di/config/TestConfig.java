package com.wxhao.study.ioc.di.config;

import com.wxhao.study.TestStudyApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author wxhao
 * @date 2018/12/6
 */

@ComponentScan(basePackages = "com.wxhao.study.ioc.di.config")
//添加自定义配置文件 , ignoreResourceNotFound 是否忽略配置文件找不到 ,默认为false (找不到就会报错)
@PropertySource(value = {"classpath:custom"}, ignoreResourceNotFound = true)
@Slf4j
public class TestConfig extends TestStudyApplication {

    @Autowired
    private CustomConfig customConfig;

    @Test
    public void config() {
        log.info("-------------------->{}", customConfig.getName());
    }


}
