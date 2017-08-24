package com.yalovchuk.service._interface.base;

import java.util.List;

public interface CrudService<T, K> {

    T create(T bean);

    T read(K id);

    T update(T bean);

    void delete(K id);

    List<T> getAll();
}
