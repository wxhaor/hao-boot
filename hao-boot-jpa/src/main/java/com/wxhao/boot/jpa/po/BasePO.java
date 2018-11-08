package com.wxhao.boot.jpa.po;


import com.wxhao.boot.jpa.listener.JpaListener;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author wxhao
 * @date 2018/1/16
 */
@EntityListeners(JpaListener.class)
@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BasePO extends BaseIdPO {

    @Column(nullable = false)
    private Date createTime;
    @Column(nullable = false)
    private Date updateTime;

}
