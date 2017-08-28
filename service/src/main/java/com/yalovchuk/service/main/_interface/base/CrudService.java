package com.yalovchuk.service.main._interface.base;

import com.yalovchuk.bean.base.Bean;

import java.util.List;

public interface CrudService<T extends Bean<K>, K extends Number> {

    T create(T bean);

    T read(K id);

    T update(T newBean, K id);

    void delete(K id);

    void deleteAll();

    List<T> getAll();
}
