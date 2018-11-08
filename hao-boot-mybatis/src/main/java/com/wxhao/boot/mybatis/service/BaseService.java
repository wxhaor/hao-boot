package com.wxhao.boot.mybatis.service;

import com.wxhao.boot.base.component.SnowflakeIdWorker;
import com.wxhao.boot.mybatis.mapper.BaseMapper;
import com.wxhao.boot.mybatis.po.BasePO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

/**
 * @author wxhao
 * @date 2018/3/22
 */
public abstract class BaseService<T extends BasePO> {

    @Resource
    protected BaseMapper<T> mapper;

    @Autowired
    private SnowflakeIdWorker idWorker;

    /**
     * 当前泛型真实类型的Class
     */
    private Class<T> modelClass;

    private BasePO buildModel(BasePO entity) {
        entity.setId(idWorker.nextId());
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        return entity;
    }

    public BaseService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public int save(T model) {
        buildModel(model);
        return mapper.insertSelective(model);
    }

    public int save(List<T> models) {
        models.forEach(t -> buildModel(t));
        return mapper.insertList(models);
    }

    public void deleteById(Long id) {
        mapper.deleteByPrimaryKey(id);
    }


    public void update(T model) {
        model.setUpdateTime(new Date());
        mapper.updateByPrimaryKeySelective(model);
    }

    public T findById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<T> findAll() {
        return mapper.selectAll();
    }


}
