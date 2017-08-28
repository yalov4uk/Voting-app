package com.yalovchuk.service.proxy._interface.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;

import java.util.List;

public interface CrudProxyService<
        T extends Bean<K>,
        K extends Number,
        D extends BeanDto<T, K>,
        R extends BeanResource<T, K>
        > {

    R create(D beanDto);

    R read(K id);

    R update(D beanDto, K id);

    void delete(K id);

    void deleteAll();

    List<R> getAll();
}
