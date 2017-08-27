package com.yalovchuk.web.controller.base._interface;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;
import com.yalovchuk.service.complex._interface.mixin.CrudComplexService;

public interface GetService<T extends Bean<K>, K extends Number, D extends BeanDto<T, K>,
        R extends BeanResource<T, K>> {

    CrudComplexService<T, K, D, R> getService();
}
