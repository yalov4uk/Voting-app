package com.yalovchuk.web.controller.base;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.service.crud._interface.base.CrudService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public abstract class CrudController<T, K> {

    protected abstract CrudService<T, K> getService();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public HttpEntity<T> create(@RequestBody T bean) {
        return new ResponseEntity<>(getService().create(bean), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HttpEntity<T> read(@PathVariable K id) {
        return new ResponseEntity<>(getService().read(id), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public HttpEntity<T> update(@PathVariable K id, @RequestBody T bean) {
        return new ResponseEntity<>(getService().update(id, bean), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HttpStatus delete(@PathVariable K id) {
        getService().delete(id);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HttpEntity<List<T>> getAll() {
        return new ResponseEntity<>(getService().getAll(), HttpStatus.FOUND);
    }
}
