package com.wxhao.boot.jpa.po;


import com.wxhao.boot.jpa.listener.PrimaryKeyJpaListener;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 实体基类注解
 *
 * @author wxhao
 * @date 2018/1/16
 */

@Data
@EqualsAndHashCode
@MappedSuperclass
@EntityListeners(PrimaryKeyJpaListener.class)
public abstract class BaseIdPO {

    @Id
    @Column(nullable = false)
    private Long id;

}

