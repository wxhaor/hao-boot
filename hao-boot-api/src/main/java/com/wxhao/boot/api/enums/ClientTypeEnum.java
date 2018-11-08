package com.wxhao.boot.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 客户端类型
 *
 * @author wxhao
 * @date 2018/3/22
 */
@Getter
@AllArgsConstructor
public enum ClientTypeEnum implements IEnum {

    H5(1, "H5"),
    IOS(2, "iOS"),
    ANDROID(3, "Android")
    ;

    private Integer code;

    private String description;

}
