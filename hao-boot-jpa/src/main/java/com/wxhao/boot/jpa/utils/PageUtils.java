package com.wxhao.boot.jpa.utils;


import com.wxhao.boot.base.pojo.BaseVO;
import com.wxhao.boot.base.pojo.PageForm;
import com.wxhao.boot.base.pojo.PageVO;
import com.wxhao.boot.base.utils.ConvertUtils;
import com.wxhao.boot.jpa.po.BasePO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * @author wxhao
 * @date 2018/4/15
 */
public class PageUtils {

    /**
     * 构建分页查询
     *
     * @param form 自定义表单
     * @return 分页查询
     */
    public static PageRequest pageRequest(PageForm form) {
        return pageRequestOf(form.getPageNum(), form.getPageSize(), Sort.unsorted());
    }

    /**
     * 构建分页查询
     *
     * @param form 自定义表单
     * @param sort 排序
     * @return 分页查询
     */
    public static PageRequest pageRequest(PageForm form, Sort sort) {
        return pageRequestOf(form.getPageNum(), form.getPageSize(), sort);
    }

    private static PageRequest pageRequestOf(Integer formPageNum, Integer formPageSize, Sort sort) {
        // 分页下标 0 为第一页
        return PageRequest.of(--formPageNum, formPageSize, sort);
    }

    /**
     * 构建分页vo 默认转换
     *
     * @param page    查询结果
     * @param voClass vo 类型
     * @param <D>     po 子类
     * @param <V>     vo 子类
     * @return
     */
    public static <D extends BasePO, V extends BaseVO> PageVO<V> pageVO(Page<D> page, Class<V> voClass) {
        PageVO<V> pageVO = new PageVO<>();
        pageVO.setTotalPage(page.getTotalPages());
        pageVO.setTotalCount(page.getTotalElements());
        pageVO.setPageNum(page.getNumber());
        pageVO.setPageSize(page.getSize());

        List<V> pageContent;
        if (page.getNumberOfElements() > 0) {
            pageContent = page.map(d -> ConvertUtils.convert(d, voClass)).getContent();
        } else {
            pageContent = Collections.emptyList();
        }
        pageVO.setContent(pageContent);

        return pageVO;
    }

    /**
     * 构建分页 自定义转换
     *
     * @param page
     * @param converter
     * @param <D>
     * @param <V>
     * @return
     */
    public static <D extends BasePO, V extends BaseVO> PageVO<V> pageVO(Page<D> page, Function<D, V> converter) {
        PageVO<V> pageVO = new PageVO<>();
        pageVO.setTotalPage(page.getTotalPages());
        pageVO.setTotalCount(page.getTotalElements());
        pageVO.setPageNum(page.getNumber());
        pageVO.setPageSize(page.getSize());

        List<V> pageContent;
        if (page.getNumberOfElements() > 0) {
            pageContent = page.map(converter).getContent();
        } else {
            pageContent = Collections.emptyList();
        }
        pageVO.setContent(pageContent);
        return pageVO;
    }


}
