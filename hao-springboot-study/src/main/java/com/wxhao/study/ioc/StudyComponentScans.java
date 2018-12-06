package com.wxhao.study.ioc;

import java.lang.annotation.*;

/**
 * @author wxhao
 * @date 2018/12/6
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface StudyComponentScans {

    StudyComponentScan[] value();

}
