package com.yalovchuk.web.utility.link._interface.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.resource.base.BeanResource;

public interface LinkAssembly<
        T extends Bean<K>,
        K extends Number,
        R extends BeanResource<T, K>
        > {

    void addLinks(R resource);
}
