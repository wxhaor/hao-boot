package com.wxhao.boot.base.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("hao.privacy-mask")
public class PrivacyMaskProperties {
    private String aesKey = "D/6ZGt4Lq/pcPbQ8O1q52A==";
}
