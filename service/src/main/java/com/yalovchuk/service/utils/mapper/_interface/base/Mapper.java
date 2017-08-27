package com.yalovchuk.service.utils.mapper._interface.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;

public interface Mapper<T extends Bean<K>, K extends Number, D extends BeanDto<T, K>,
        R extends BeanResource<T, K>> {

    T dtoToBean(D beanDto);

    R beanToResource(T bean);
}
