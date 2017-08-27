package com.yalovchuk.service.proxy.implementation.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.service.utility.mapper._interface.base.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CrudProxyService<
        T extends Bean<K>,
        K extends Number,
        D extends BeanDto<T, K>,
        R extends BeanResource<T, K>
        > implements com.yalovchuk.service.proxy._interface.base.CrudProxyService<T, K, D, R> {

    protected abstract CrudService<T, K> getService();

    protected abstract Mapper<T, K, D, R> getMapper();

    public R create(D beanDto) {
        T bean = getMapper().dtoToBean(beanDto);
        bean = getService().create(bean);
        return getMapper().beanToResource(bean);
    }

    public R read(K id) {
        T bean = getService().read(id);
        return getMapper().beanToResource(bean);
    }

    public R update(D beanDto, K id) {
        T bean = getMapper().dtoToBean(beanDto);
        bean = getService().update(bean, id);
        return getMapper().beanToResource(bean);
    }

    public void delete(K id) {
        getService().delete(id);
    }

    public List<R> getAll() {
        return getService().getAll().stream().map(this.getMapper()::beanToResource).collect(Collectors.toList());
    }
}
