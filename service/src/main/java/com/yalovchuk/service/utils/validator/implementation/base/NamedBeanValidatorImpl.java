package com.yalovchuk.service.utils.validator.implementation.base;

import com.yalovchuk.bean.base.NamedBean;
import com.yalovchuk.dto.base.NamedBeanDto;
import com.yalovchuk.service.utils.validator._interface.base.NamedBeanValidator;

public abstract class NamedBeanValidatorImpl<T extends NamedBean<K>, K extends Number> extends BeanValidatorImpl<T, K>
        implements NamedBeanValidator<T, K> {

    @Override
    public boolean validateName(T namedBean) {
        String name = namedBean.getName();
        return name != null && name.length() >= 2;
    }
}
