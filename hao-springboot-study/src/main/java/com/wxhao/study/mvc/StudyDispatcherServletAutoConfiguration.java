package com.wxhao.study.mvc;

import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author wxhao
 * @date 2018/12/6
 */
//配置文件
@Configuration
// 配置条件满足 TestCondition 的验证
@Conditional(StudyCondition.class)
//如果存在 TestConditionalOnClass 则进行配置
@ConditionalOnClass(StudyConditionalOnClass.class)
//如果存在对应的配置文件 则启用配置
@EnableConfigurationProperties(StudyEnableConfigurationProperties.class)
public class StudyDispatcherServletAutoConfiguration {


    @Bean
    //如果存在类定义则配置
    @ConditionalOnBean(MultipartResolver.class)
    //如果判断不存在 bean 名称为 DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME ,则配置Bean
    @ConditionalOnMissingBean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME + "study")
    public MultipartResolver multipartResolver(MultipartResolver resolver) {
        // Detect if the user has created a MultipartResolver but named it incorrectly
        return resolver;
    }

}

@ConfigurationProperties
class StudyEnableConfigurationProperties {

}

class StudyConditionalOnClass {

}

class StudyCondition extends SpringBootCondition {
    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return new ConditionOutcome(true, "这是啥");
    }
}