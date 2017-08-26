package com.yalovchuk.service.complex.implementation.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;
import com.yalovchuk.service.complex._interface.base.CrudComplexService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CrudComplexServiceImpl<T extends Bean<K>, K extends Number, D extends BeanDto<T, K>,
        R extends BeanResource<T, K>> extends CrudServiceImpl<T, K> implements CrudComplexService<T, K, D, R> {

    @Autowired
    protected ModelMapper modelMapper;

    protected abstract Class<T> getBeanClass();

    protected abstract Class<D> getDtoClass();

    protected abstract Class<R> getResourceClass();

    @Override
    public R create(D beanDto) {
        T bean = dtoToBean(beanDto);
        bean = super.create(bean);
        return beanToResource(bean);
    }

    @Override
    public R readResource(K id) {
        T bean = super.read(id);
        return beanToResource(bean);
    }

    @Override
    public R update(K id, D beanDto) {
        T bean = dtoToBean(beanDto);
        bean = super.update(id, bean);
        return beanToResource(bean);
    }

    @Override
    public List<R> getAllResources() {
        return super.getAll().stream().map(this::beanToResource).collect(Collectors.toList());
    }

    private T dtoToBean(D beanDto) {
        return modelMapper.map(beanDto, getBeanClass());
    }

    private R beanToResource(T bean) {
        return modelMapper.map(bean, getResourceClass());
    }
}
