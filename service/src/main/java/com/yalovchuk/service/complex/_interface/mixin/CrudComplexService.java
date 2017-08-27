package com.yalovchuk.service.complex._interface.mixin;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.service.utils.mapper._interface.base.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface CrudComplexService<T extends Bean<K>, K extends Number, D extends BeanDto<T, K>,
        R extends BeanResource<T, K>> extends CrudService<T, K> {

    Mapper<T, K, D, R> getMapper();

    default R createResource(D beanDto) {
        T bean = getMapper().dtoToBean(beanDto);
        bean = create(bean);
        return getMapper().beanToResource(bean);
    }

    default R readResource(K id) {
        T bean = read(id);
        return getMapper().beanToResource(bean);
    }

    default R updateResource(K id, D beanDto) {
        T bean = getMapper().dtoToBean(beanDto);
        bean = update(id, bean);
        return getMapper().beanToResource(bean);
    }

    default void deleteResource(K id) {
        delete(id);
    }

    default List<R> getAllResources() {
        return getAll().stream().map(this.getMapper()::beanToResource).collect(Collectors.toList());
    }
}
