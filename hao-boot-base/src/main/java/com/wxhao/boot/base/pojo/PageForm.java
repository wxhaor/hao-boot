package com.wxhao.boot.base.pojo;

import lombok.Getter;

/**
 * @author wxhao
 * @date 2018/3/21
 */
@Getter
public class PageForm {

    /**
     * 分页数量
     */
    protected Integer pageSize = 10;

    /**
     * 页码
     */
    protected Integer pageNum = 1;

    public void setPageSize(Integer pageSize) {
        if (pageSize != null && pageSize > 0) {
            this.pageSize = pageSize;
        }

    }

    public void setPageNum(Integer pageNum) {
        if (pageNum != null && pageNum > 0) {
            this.pageNum = pageNum;
        }
    }
}
