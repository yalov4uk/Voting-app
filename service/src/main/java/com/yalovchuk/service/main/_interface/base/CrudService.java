package com.yalovchuk.service.main._interface.base;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrudService<T, K> {

    T create(T bean);

    T read(K id);

    T update(K id, T bean);

    void delete(K id);

    List<T> getAll();
}
