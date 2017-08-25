package com.yalovchuk.resource.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.bean.base.NamedBean;

public class BaseNamedResource<T extends NamedBean<K>, K extends Number> extends BaseResource<T, K> {

    private String name;

    protected BaseNamedResource(K pk, String name) {
        super(pk);
        this.name = name;
    }

    protected BaseNamedResource(T namedBean) {
        super(namedBean);
        this.name = namedBean.getName();
    }

    public String getName() {
        return name;
    }
}
