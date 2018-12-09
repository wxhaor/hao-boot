package com.wxhao.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @author wxhao
 * @date 2018/12/6
 */

@SpringBootApplication
@ComponentScan
//添加自定义配置文件 , ignoreResourceNotFound 是否忽略配置文件找不到 ,默认为false (找不到就会报错)
@PropertySource(value = {"classpath:custom.properties"}, ignoreResourceNotFound = false)
//引入xml
//@ImportResource(value = {"classpath:xxx.xml"})
@Slf4j
public class StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class,args);
    }
}

