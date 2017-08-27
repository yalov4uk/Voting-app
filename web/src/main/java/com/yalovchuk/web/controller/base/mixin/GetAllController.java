package com.yalovchuk.web.controller.base.mixin;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;
import com.yalovchuk.web.controller.base._interface.GetService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface GetAllController<T extends Bean<K>, K extends Number, D extends BeanDto<T, K>,
        R extends BeanResource<T, K>> extends GetService<T, K, D, R> {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    default HttpEntity<List<R>> getAll() {
        return new ResponseEntity<>(getService().getAllResources(), HttpStatus.OK);
    }

}
