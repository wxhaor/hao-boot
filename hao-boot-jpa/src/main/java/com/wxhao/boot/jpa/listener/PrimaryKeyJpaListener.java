package com.wxhao.boot.jpa.listener;


import com.wxhao.boot.base.component.SnowflakeIdWorker;
import com.wxhao.boot.base.helper.ApplicationContextHelper;
import com.wxhao.boot.jpa.po.BasePO;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.PrePersist;

/**
 * EntityListener
 *
 * @author wxhao
 * @date 2017年6月18日下午3:24:18
 */

@Slf4j
public class PrimaryKeyJpaListener {


    /**
     * 保存前处理
     *
     * @param po 基类
     */
    @PrePersist
    public void prePersist(BasePO po) {
        SnowflakeIdWorker idWorker = ApplicationContextHelper.getBean(SnowflakeIdWorker.class);
        po.setId(idWorker.nextId());
    }

}