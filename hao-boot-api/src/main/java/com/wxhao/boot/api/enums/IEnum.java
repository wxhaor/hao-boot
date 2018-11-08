package com.wxhao.boot.api.enums;

/**
 * 通用枚举接口
 * @author wxhao
 * @date	2017年5月4日下午3:04:15
 * @version 1.0
 */
public interface IEnum {
	
	String IENUM_CODE = "code";
	String IENUM_DESCRIBE = "description";
	
	/**
	 * 获取枚举 code
	 * @return
	 */
	Integer getCode();
 
    /**
     * 获取枚举 描述
     * @return
     */
    String getDescription();
	
}
