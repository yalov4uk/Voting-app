package com.yalovchuk.service.complex._interface.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;

import java.util.List;

public interface CrudComplexService<T extends Bean<K>, K extends Number, D extends BeanDto<T, K>,
        R extends BeanResource<T, K>> {

    R create(D beanDto);

    R readResource(K id);

    R update(K id, D beanDto);

    void delete(K id);

    List<R> getAllResources();
}
