package com.wxhao.boot.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 响应值枚举
 *
 * @author wxhao
 */
@Getter
@AllArgsConstructor
public enum ResponseResultEnum {
    /**
     * 成功
     */
    SUCCESS("0000", "成功"),
    /**
     * 权限异常
     */
    AUTH_EXP("AUTH", "权限异常"),
    /**
     * 业务异常
     */
    BIZ_EXP("BIZ", "业务异常"),
    /**
     * 异常
     */
    ERROR("ERROR", "系统错误");

    private String code;

    private String description;

}
