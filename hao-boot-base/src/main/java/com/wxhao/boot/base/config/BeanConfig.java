package com.wxhao.boot.base.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wxhao.boot.base.component.PrivacyMasks;
import com.wxhao.boot.base.component.ReloadableMessageSource;
import com.wxhao.boot.base.component.SnowflakeIdWorker;
import com.wxhao.boot.base.properties.PrivacyMaskProperties;
import com.wxhao.boot.base.properties.SnowflakeProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author wxhao
 * @date 2018/3/15
 */
@Component
public class BeanConfig {

    @Bean
    public SnowflakeIdWorker snowflakeIdWorker(SnowflakeProperties properties) {
        return new SnowflakeIdWorker(properties.getWorkerId(), properties.getDataCenterId());
    }

    @Bean
    public PrivacyMasks privacyMasks(PrivacyMaskProperties properties) {
        return new PrivacyMasks(properties);
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

    @Bean
    public ReloadableMessageSource reloadableMessageSource() {
        return new ReloadableMessageSource();
    }

}
