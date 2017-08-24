package com.yalovchuk.service.implementation.base;

import com.yalovchuk.service._interface.base.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public abstract class CrudServiceImpl<T, K extends Serializable> implements CrudService<T, K> {

    protected abstract CrudRepository<T, K> getDao();

    @Override
    public T create(T bean) {
        return getDao().save(bean);
    }

    @Override
    public T read(K id) {
        return getDao().findOne(id);
    }

    @Override
    public T update(T bean) {
        return getDao().save(bean);
    }

    @Override
    public void delete(K id) {
        getDao().delete(id);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) getDao().findAll();
    }
}
