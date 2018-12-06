package com.wxhao.study.ioc;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @author wxhao
 * @date 2018/12/6
 */

public interface StudyApplicationContext extends
        //环境可配置接口
        EnvironmentCapable,
        ListableBeanFactory,
        HierarchicalBeanFactory,
        //国际化接口
        MessageSource,
        //应用事件发布接口
        ApplicationEventPublisher,
        //资源模式解析接口
        ResourcePatternResolver {



}
