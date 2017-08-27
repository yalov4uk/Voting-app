package com.yalovchuk.service.utility.validator.implementation.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.service.utility.validator._interface.base.BeanValidator;

public abstract class BeanValidatorImpl<T extends Bean<K>, K extends Number> implements BeanValidator<T, K> {

    @Override
    public boolean validateId(T bean) {
        return true;
    }
}
