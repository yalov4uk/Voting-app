package com.yalovchuk.resource.base;

import com.yalovchuk.bean.base.NamedBean;

public class NamedBeanResource<T extends NamedBean<K>, K extends Number> extends BeanResource<T, K> {

    private String name;

    protected NamedBeanResource(K pk, String name) {
        super(pk);
        this.name = name;
    }

    protected NamedBeanResource(T namedBean) {
        super(namedBean);
        this.name = namedBean.getName();
    }

    public String getName() {
        return name;
    }
}
