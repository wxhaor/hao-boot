package com.wxhao.boot.base.pojo;

import lombok.Data;

/**
 * @author wxhao
 * @date 2018/3/16
 */
@Data
public class WebDefaultVO {

    /**
     * 服务名称
     */
    private String serverName;

    /**
     * 环境名称
     */
    private String envName;

    /**
     * 数据中心ID
     */
    private long dataCenterId = 0L;

    /**
     * 工作ID
     */
    private long workerId = 0L;

}
