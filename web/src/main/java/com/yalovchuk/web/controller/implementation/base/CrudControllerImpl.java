package com.yalovchuk.web.controller.implementation.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;
import com.yalovchuk.service.proxy._interface.base.CrudProxyService;
import com.yalovchuk.web.controller._interface.base.CrudController;
import com.yalovchuk.web.utility.link._interface.base.LinkAssembly;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public abstract class CrudControllerImpl<
        T extends Bean<K>,
        K extends Number,
        D extends BeanDto<T, K>,
        R extends BeanResource<T, K>
        > implements CrudController<T, K, D, R> {

    protected abstract CrudProxyService<T, K, D, R> getService();

    protected abstract LinkAssembly<T, K, R> getLinkAssembly();

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<R> create(@RequestBody D beanDto) {
        R resource = getService().create(beanDto);
        addLinks(resource);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HttpEntity<R> read(@PathVariable K id) {
        R resource = getService().read(id);
        addLinks(resource);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public HttpEntity<R> update(@RequestBody D beanDto, @PathVariable K id) {
        R resource = getService().update(beanDto, id);
        addLinks(resource);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HttpStatus delete(@PathVariable K id) {
        getService().delete(id);
        return HttpStatus.NO_CONTENT;
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public HttpStatus deleteAll() {
        getService().deleteAll();
        return HttpStatus.NO_CONTENT;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<R>> getAll() {
        List<R> resources = getService().getAll();
        resources.forEach(this::addLinks);
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    protected void addLinks(R resource) {
        getLinkAssembly().addLinks(resource);
    }
}
