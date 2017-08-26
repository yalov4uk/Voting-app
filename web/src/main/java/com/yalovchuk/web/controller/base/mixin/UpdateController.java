package com.yalovchuk.web.controller.base.mixin;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.web.controller.base._interface.GetService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UpdateController<T extends Bean<K>, K extends Number> extends GetService<T, K> {

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    default HttpEntity<T> update(@PathVariable K id, @RequestBody T bean) {
        return new ResponseEntity<>(getService().update(id, bean), HttpStatus.OK);
    }
}
