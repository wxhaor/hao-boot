package com.wxhao.boot.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wxhao
 * @date 2018/12/9
 */
@AllArgsConstructor
@Getter
public enum SexEnum implements IEnum{

    MAN(1, "男"),
    WOMAN(2, "女");

    private Integer code;

    private String description;


}
