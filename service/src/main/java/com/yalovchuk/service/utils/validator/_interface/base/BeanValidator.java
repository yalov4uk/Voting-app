package com.yalovchuk.service.utils.validator._interface.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;

public interface BeanValidator<T extends Bean<K>, K extends Number> {

    boolean validateId(T bean);
}
