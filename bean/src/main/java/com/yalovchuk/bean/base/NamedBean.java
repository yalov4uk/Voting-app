package com.yalovchuk.bean.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class NamedBean<K extends Number> extends Bean<K> {

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    protected NamedBean() {
        super();
    }

    public NamedBean(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NamedBean)) return false;
        if (!super.equals(o)) return false;
        NamedBean<?> namedBean = (NamedBean<?>) o;
        return Objects.equals(name, namedBean.name);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", name='" + name + '\'';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
