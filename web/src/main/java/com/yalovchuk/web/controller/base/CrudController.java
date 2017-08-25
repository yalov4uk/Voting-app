package com.yalovchuk.web.controller.base;

import com.yalovchuk.bean.base.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public abstract class CrudController<T extends Bean<K>, K extends Number> extends RudController<T, K> {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public HttpEntity<T> create(@RequestBody T bean) {
        return new ResponseEntity<>(getService().create(bean), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HttpEntity<List<T>> getAll() {
        return new ResponseEntity<>(getService().getAll(), HttpStatus.OK);
    }

}
