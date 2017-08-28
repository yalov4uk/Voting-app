package com.yalovchuk.service.utility.mapper.implementation.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;
import com.yalovchuk.service.utility.mapper._interface.base.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MapperImpl<
        T extends Bean<K>,
        K extends Number,
        D extends BeanDto<T, K>,
        R extends BeanResource<T, K>
        > implements Mapper<T, K, D, R> {

    @Autowired
    private ModelMapper modelMapper;

    protected abstract Class<T> getBeanClass();

    protected abstract Class<R> getResourceClass();

    @Override
    public T dtoToBean(D beanDto) {
        return modelMapper.map(beanDto, getBeanClass());
    }

    @Override
    public R beanToResource(T bean) {
        R resource = modelMapper.map(bean, getResourceClass());
        resource.setPk(bean.getId());
        return resource;
    }
}
