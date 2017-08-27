package com.yalovchuk.resource.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yalovchuk.bean.base.Bean;
import org.springframework.hateoas.ResourceSupport;

public abstract class BeanResource<T extends Bean<K>, K extends Number> extends ResourceSupport {

    @JsonProperty("id")
    private K pk;

    protected BeanResource() {
    }

    protected BeanResource(K pk) {
        this.pk = pk;
    }

    protected BeanResource(T bean) {
        this.pk = bean.getId();
    }

    public K getPk() {
        return pk;
    }

    public void setPk(K pk) {
        this.pk = pk;
    }
}
