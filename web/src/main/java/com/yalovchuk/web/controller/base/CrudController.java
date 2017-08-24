package com.yalovchuk.web.controller.base;

import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.service.utils._interface.Encryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public abstract class CrudController<T, K> {

    @Autowired
    protected Encryptor encryptor;

    protected abstract CrudService<T, K> getService();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public T create(@RequestBody T bean) {
        return getService().create(bean);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T read(@PathVariable K id) {
        return getService().read(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public T update(@PathVariable K id, @RequestBody T bean) {
        return getService().update(id, bean);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable K id) {
        getService().delete(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<T> getAll() {
        return getService().getAll();
    }
}
