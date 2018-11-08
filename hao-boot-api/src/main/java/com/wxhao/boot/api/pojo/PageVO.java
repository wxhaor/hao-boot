package com.wxhao.boot.api.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author wxhao
 * @date 2018/3/21
 */
@Data
public class PageVO<T> {

    /**
     * 分页数量
     */
    private Integer pageSize;

    /**
     * 页码
     */
    private  Integer pageNum;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 记录总数
     */
    private Long totalCount;

    private List<T> content;

}
