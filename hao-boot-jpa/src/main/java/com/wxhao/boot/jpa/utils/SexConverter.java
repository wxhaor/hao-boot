package com.wxhao.boot.jpa.utils;

import com.wxhao.boot.api.enums.SexEnum;
import com.wxhao.boot.base.utils.EnumUtils;

import javax.persistence.AttributeConverter;

/**
 * @author wxhao
 * @date 2018/12/9
 */
public class SexConverter implements AttributeConverter<SexEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SexEnum attribute) {
        return attribute.getCode();
    }

    @Override
    public SexEnum convertToEntityAttribute(Integer dbData) {
        return EnumUtils.getEunmByCode(dbData, SexEnum.class);
    }

    //字段加注解 @Convert(converter = SexConverter.class);
}
