package com.wxhao.study.ioc.di.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxhao
 * @date 2018/12/7
 */
@RestController
public class CustomConfigController {

    @Autowired
    private CustomConfigProperties customConfigProperties;

    @GetMapping("/show")
    public CustomConfigProperties show(){
        return customConfigProperties;
    }

}
