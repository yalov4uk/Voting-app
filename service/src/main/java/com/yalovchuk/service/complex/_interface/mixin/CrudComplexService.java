package com.yalovchuk.service.complex._interface.mixin;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;
import com.yalovchuk.service.main._interface.base.CrudService;

import java.util.List;
import java.util.stream.Collectors;

public interface CrudComplexService<T extends Bean<K>, K extends Number, D extends BeanDto<T, K>,
        R extends BeanResource<T, K>> extends CrudService<T, K> {

    T dtoToBean(D beanDto);

    R beanToResource(T bean);

    default R createResource(D beanDto) {
        T bean = dtoToBean(beanDto);
        bean = create(bean);
        return beanToResource(bean);
    }

    default R readResource(K id) {
        T bean = read(id);
        return beanToResource(bean);
    }

    default R updateResource(K id, D beanDto) {
        T bean = dtoToBean(beanDto);
        bean = update(id, bean);
        return beanToResource(bean);
    }

    default List<R> getAllResources() {
        return getAll().stream().map(this::beanToResource).collect(Collectors.toList());
    }
}
