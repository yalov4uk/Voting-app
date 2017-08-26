package com.yalovchuk.service.main._interface.base;

import com.yalovchuk.bean.base.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CrudService<T extends Bean<K>, K extends Number> {

    T create(T bean);

    T read(K id);

    T update(K id, T bean);

    void delete(K id);

    List<T> getAll();
}
