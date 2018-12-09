package com.wxhao.study.aop.custom;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wxhao
 * @date 2018/12/7
 */
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if (name != null) {
            log.info(name + " hello!");
        }
    }
}
