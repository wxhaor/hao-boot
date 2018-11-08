package com.wxhao.boot.jpa.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wxhao.boot.base.component.SnowflakeIdWorker;
import com.wxhao.boot.jpa.po.BasePO;
import com.wxhao.boot.jpa.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author wxhao
 * @date 2018/3/16
 */
public abstract class BaseService<T extends BasePO, ID, M extends BaseRepository<T, ID>> {

    private Class<T> poClass;

    public BaseService() {
        ResolvableType serviceResolvableType = ResolvableType.forClass(this.getClass());
        poClass = (Class<T>) serviceResolvableType.getGeneric(0).resolve();
    }

    @Autowired
    protected M repository;

    @Autowired
    protected SnowflakeIdWorker idWorker;

    @Autowired
    protected ObjectMapper jsonMapper;


    @Transactional(rollbackFor = Exception.class)
    public <S extends T> S save(S entity) {
        return repository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public <S extends T> S saveAndFlush(S entity) {
        return repository.saveAndFlush(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public T getOne(ID id) {
        return repository.getOne(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public long count() {
        return repository.count();
    }

    public <S extends T> long count(Example<S> example) {
        return repository.count(example);
    }

    public List<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }


    public <S extends T> List<S> findAll(Example<S> example) {
        return repository.findAll(example);
    }


    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return repository.findAll(example, sort);
    }

    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    public List<T> findAllById(Iterable<ID> ids) {
        return repository.findAllById(ids);
    }

    public void flush() {
        repository.flush();
    }

//    public <V extends BaseVO, F extends PageForm> PageVO<V> page(F form, Class<V> voClass) {
//
//        T food = ConvertUtils.convert(form, poClass);
//
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                // 姓名采用“开始匹配”的方式查询
//                .withMatcher("foodName", ExampleMatcher.GenericPropertyMatchers.startsWith())
//                // 忽略属性：是否关注。因为是基本类型，需要忽略掉
//                .withIgnorePaths("focus");
//
//        Example<T> example = Example.of(food, matcher);
//
//        // 排序
//        Sort.Order order = Sort.Order.asc("id");
//        Sort sort = Sort.by(order);
//
//        Pageable pageRequest = PageUtils.pageRequest(form, sort);
//
//        return PageUtils.pageVO(this.findAll(example, pageRequest), voClass);
//    }
//
//    private interface PageFunction {
//
//    }

}
