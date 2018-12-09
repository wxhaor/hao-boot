package com.wxhao.study.aop.custom;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wxhao
 * @date 2018/12/7
 */
@Data
@AllArgsConstructor
public class Invocation {

    private Object target;
    private Method method;
    private Object[] params;

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }


}
