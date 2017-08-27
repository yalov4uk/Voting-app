package com.yalovchuk.service.utility.validator._interface.base;

import com.yalovchuk.bean.base.NamedBean;

public interface NamedBeanValidator<T extends NamedBean<K>, K extends Number> extends BeanValidator<T, K> {

    boolean validateName(T namedBean);
}
