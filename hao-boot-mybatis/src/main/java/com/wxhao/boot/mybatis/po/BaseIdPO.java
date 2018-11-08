package com.wxhao.boot.mybatis.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 实体基类注解
 *
 * @author wxhao
 * @date 2018/1/16
 */

@Data
@MappedSuperclass
public abstract class BaseIdPO {

    @Id
    @Column(nullable = false)
    private Long id;

}

