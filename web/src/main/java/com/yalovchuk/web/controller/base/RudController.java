package com.yalovchuk.web.controller.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.service.main._interface.base.CrudService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class RudController<T extends Bean<K>, K extends Number> {

    protected abstract CrudService<T, K> getService();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HttpEntity<T> read(@PathVariable K id) {
        return new ResponseEntity<>(getService().read(id), HttpStatus.OK);
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
}
