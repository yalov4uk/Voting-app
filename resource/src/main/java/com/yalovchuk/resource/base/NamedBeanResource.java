package com.yalovchuk.resource.base;

import com.yalovchuk.bean.base.NamedBean;

public abstract class NamedBeanResource<T extends NamedBean<K>, K extends Number> extends BeanResource<T, K> {

    private String name;

    protected NamedBeanResource() {
        super();
    }

    protected NamedBeanResource(K id, String name) {
        super(id);
        this.name = name;
    }

    protected NamedBeanResource(T namedBean) {
        super(namedBean);
        this.name = namedBean.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
