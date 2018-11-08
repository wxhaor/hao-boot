package com.wxhao.boot.mybatis.mapper;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * mapper基类
 * @author wxhao
 * @date 2018/3/22
 */

public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {


}
