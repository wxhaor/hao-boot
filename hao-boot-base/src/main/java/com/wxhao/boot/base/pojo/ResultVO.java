package com.wxhao.boot.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * vo基类
 *
 * @author wxhao
 * @date 2018/3/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T> {

    private String code;

    private String msg;

    private T data;

}
