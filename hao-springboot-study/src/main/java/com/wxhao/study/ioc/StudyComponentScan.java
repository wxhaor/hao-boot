package com.wxhao.study.ioc;

import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author wxhao
 * @date 2018/12/6
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Repeatable(StudyComponentScans.class)
public @interface StudyComponentScan {

    // 定义扫描的包
    @AliasFor("basePackages")
    String[] value() default {};

    // 定义扫描的包
    @AliasFor("value")
    String[] basePackages() default {};

    // 定义扫描的类
    Class<?>[] basePackageClasses() default {};

    //BeanName  生成器
    Class<? extends BeanNameGenerator> nameGenerator() default BeanNameGenerator.class;

    // 作用域解析器
    Class<? extends ScopeMetadataResolver> scopeResolver() default AnnotationScopeMetadataResolver.class;

    // 作用域 代理模式
    ScopedProxyMode scopedProxy() default ScopedProxyMode.DEFAULT;

    // 资源匹配模式
    String resourcePattern() default "\"**/*.class\"";//ClassPathScanningCandidateComponentProvider.DEFAULT_RESOURCE_PATTERN;

    //是否启用默认的过滤器
    boolean useDefaultFilters() default true;

    //当满足过滤条件时扫描
    ComponentScan.Filter[] includeFilters() default {};

    //当不满足过滤条件时扫描
    ComponentScan.Filter[] excludeFilters() default {};

    //是否延迟初始化
    boolean lazyInit() default false;


    //定义过滤器
    @Retention(RetentionPolicy.RUNTIME)
    @Target({})
    @interface Filter {

        //过滤器类型,可以按注解类型或者正则式过滤
        FilterType type() default FilterType.ANNOTATION;

        //定义过滤的类
        @AliasFor("classes")
        Class<?>[] value() default {};

        //定义过滤的类
        @AliasFor("value")
        Class<?>[] classes() default {};

        //匹配方式
        String[] pattern() default {};

    }
}
