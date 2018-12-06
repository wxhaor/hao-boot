package com.wxhao.study.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;

/**
 * @author wxhao
 * @date 2018/12/6
 */
public interface StudyBeanFactory {

    //前缀
    String FACTORY_BEAN_PREFIX = "&";

    //多个getBean方法
    Object getBean(String name) throws BeansException;

    //是否包含bean
    boolean containsBean(String name);

    //bean 是否是单例, 默认情况都是单例存在
    boolean isSingleton(String name) throws NoSuchBeanDefinitionException;

    //bean 是否原型
    boolean isPrototype(String name) throws NoSuchBeanDefinitionException;

    //是否类型匹配
    boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException;

    //获取bean的类型
    @Nullable
    Class<?> getType(String name) throws NoSuchBeanDefinitionException;

    //获取bean的别名
    String[] getAliases(String name);

}
