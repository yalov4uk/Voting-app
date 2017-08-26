package com.yalovchuk.web.controller.base.mixin;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.web.controller.base._interface.GetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface DeleteController<T extends Bean<K>, K extends Number> extends GetService<T, K> {

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    default HttpStatus delete(@PathVariable K id) {
        getService().delete(id);
        return HttpStatus.NO_CONTENT;
    }
}
