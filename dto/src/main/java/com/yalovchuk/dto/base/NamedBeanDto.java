package com.yalovchuk.dto.base;

import com.yalovchuk.bean.base.NamedBean;

public abstract class NamedBeanDto<T extends NamedBean<K>, K extends Number> extends BeanDto<T, K> {

    private String name;

    protected NamedBeanDto() {
        super();
    }

    public NamedBeanDto(K id, String name) {
        super(id);
        this.name = name;
    }

    public NamedBeanDto(T bean) {
        super(bean);
        this.name = bean.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
