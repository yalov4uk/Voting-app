package com.yalovchuk.service.utils.validator._interface.base;

import com.yalovchuk.bean.base.NamedBean;
import com.yalovchuk.dto.base.NamedBeanDto;

public interface NamedBeanValidator<T extends NamedBean<K>, K extends Number> extends BeanValidator<T, K> {

    boolean validateName(T namedBean);
}
