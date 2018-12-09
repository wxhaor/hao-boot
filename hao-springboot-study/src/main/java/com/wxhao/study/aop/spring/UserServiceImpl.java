package com.wxhao.study.aop.spring;

import org.springframework.stereotype.Service;

/**
 * @author wxhao
 * @date 2018/12/9
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public void printUser(){
        System.out.println("printUser");
    }
}
