package com.yalovchuk.dto.base;

import com.yalovchuk.bean.base.Bean;

public abstract class BeanDto<T extends Bean<K>, K extends Number> {

    private K id;

    public BeanDto(K id) {
        this.id = id;
    }

    public BeanDto(T bean) {
        this.id = bean.getId();
    }

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }
}
