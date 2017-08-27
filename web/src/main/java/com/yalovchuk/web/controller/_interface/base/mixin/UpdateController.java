package com.yalovchuk.web.controller._interface.base.mixin;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;
import com.yalovchuk.web.controller._interface.base._interface.GetService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UpdateController<
        T extends Bean<K>,
        K extends Number,
        D extends BeanDto<T, K>,
        R extends BeanResource<T, K>
        > extends GetService<T, K, D, R> {

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    default HttpEntity<R> update(@PathVariable K id, @RequestBody D beanDto) {
        return new ResponseEntity<>(getService().update(id, beanDto), HttpStatus.OK);
    }
}