package com.wxhao.boot.jpa.listener;


import com.wxhao.boot.jpa.po.BasePO;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * EntityListener
 *
 * @author wxhao
 * @date 2017年6月18日下午3:24:18
 */
public class JpaListener {

    /**
     * 保存前处理
     *
     * @param po 基类
     */
    @PrePersist
    public void prePersist(BasePO po) {
        po.setCreateTime(new Date());
        po.setUpdateTime(new Date());
    }

    /**
     * 更新前处理
     *
     * @param po 基类
     */
    @PreUpdate
    public void preUpdate(BasePO po) {
        po.setUpdateTime(new Date());
    }

}