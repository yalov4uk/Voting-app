package com.yalovchuk.service.utility.validator._interface.base;

import com.yalovchuk.bean.base.Bean;

public interface BeanValidator<T extends Bean<K>, K extends Number> {

    boolean validateId(T bean);
}
