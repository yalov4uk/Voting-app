package com.yalovchuk.web.controller.base.mixin;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.web.controller.base._interface.GetService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface CreateController<T extends Bean<K>, K extends Number> extends GetService<T, K> {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    default HttpEntity<T> create(@RequestBody T bean) {
        return new ResponseEntity<>(getService().create(bean), HttpStatus.CREATED);
    }
}
