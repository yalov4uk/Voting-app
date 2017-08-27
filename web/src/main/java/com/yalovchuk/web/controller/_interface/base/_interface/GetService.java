package com.yalovchuk.web.controller._interface.base._interface;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;
import com.yalovchuk.service.proxy._interface.base.CrudProxyService;

public interface GetService<
        T extends Bean<K>,
        K extends Number,
        D extends BeanDto<T, K>,
        R extends BeanResource<T, K>
        > {

    CrudProxyService<T, K, D, R> getService();
}
