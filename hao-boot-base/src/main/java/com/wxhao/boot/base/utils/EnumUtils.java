package com.wxhao.boot.base.utils;


import com.wxhao.boot.api.enums.IEnum;
import com.wxhao.boot.api.pojo.EnumVO;

import java.util.ArrayList;
import java.util.List;

/**
 * 枚举类操作类
 * EnumsUtils
 *
 * @author wxhao
 * @date 2017年7月22日上午11:44:57
 */
public class EnumUtils {

    /**
     * 获取枚举所有属性
     *
     * @param enumClass
     * @return
     */
    public static <T extends IEnum> List<EnumVO> getEnumList(Class<T> enumClass) {

        List<EnumVO> list = new ArrayList<>();
        for (T iEnum : enumClass.getEnumConstants()) {
            EnumVO enumVO = new EnumVO();
            enumVO.setCode(iEnum.getCode());
            enumVO.setDescription(iEnum.getDescription());
            list.add(enumVO);
        }
        return list;
    }

    /**
     * 根据code获取枚举
     *
     * @param code
     * @param enumClass
     * @return
     */
    public static <T extends IEnum> T getEunmByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }

    /**
     * 根据枚举code获取描述
     *
     * @param code
     * @param enumClass
     * @param <T>
     * @return
     */
    public static <T extends IEnum> String getDescribeByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each.getDescription();
            }
        }
        return null;
    }

}
