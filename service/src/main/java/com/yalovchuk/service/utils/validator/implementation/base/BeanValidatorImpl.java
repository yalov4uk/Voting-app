package com.yalovchuk.service.utils.validator.implementation.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.service.utils.validator._interface.base.BeanValidator;

public abstract class BeanValidatorImpl<T extends Bean<K>, K extends Number> implements BeanValidator<T, K> {

    @Override
    public boolean validateId(T bean) {
        return true;
    }
}
