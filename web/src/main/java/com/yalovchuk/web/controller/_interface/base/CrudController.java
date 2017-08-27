package com.yalovchuk.web.controller._interface.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface CrudController<
        T extends Bean<K>,
        K extends Number,
        D extends BeanDto<T, K>,
        R extends BeanResource<T, K>
        > {

    HttpEntity<R> create(D beanDto);

    HttpEntity<R> read(K id);

    HttpEntity<R> update(D beanDto, K id);

    HttpStatus delete(K id);

    HttpEntity<List<R>> getAll();
}
