package com.yalovchuk.web.controller._interface.base.mixin;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.dto.base.BeanDto;
import com.yalovchuk.resource.base.BeanResource;
import com.yalovchuk.web.controller._interface.base._interface.GetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface DeleteController<
        T extends Bean<K>,
        K extends Number,
        D extends BeanDto<T, K>,
        R extends BeanResource<T, K>
        > extends GetService<T, K, D, R> {

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    default HttpStatus delete(@PathVariable K id) {
        getService().delete(id);
        return HttpStatus.NO_CONTENT;
    }
}
