package com.wxhao.boot.mybatis.po;




import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author wxhao
 * @date 2018/1/16
 */
@MappedSuperclass
@Data
public abstract class BasePO extends BaseIdPO {

    @Column(nullable = false)
    private Date createTime;
    @Column(nullable = false)
    private Date updateTime;

}
