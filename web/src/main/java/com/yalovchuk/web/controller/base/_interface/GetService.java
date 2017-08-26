package com.yalovchuk.web.controller.base._interface;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.service.main._interface.base.CrudService;

public interface GetService<T extends Bean<K>, K extends Number> {

    CrudService<T, K> getService();
}
