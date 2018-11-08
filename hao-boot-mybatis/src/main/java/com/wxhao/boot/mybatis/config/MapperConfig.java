package com.wxhao.boot.mybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * @author wxhao
 * @date 2018/3/21
 */
@Configuration
public class MapperConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setMarkerInterface(BaseMapper.class);
        mapperScannerConfigurer.setBasePackage("com.wxhao.hao.manage.server.mapper");
        return  mapperScannerConfigurer;
    }

}
