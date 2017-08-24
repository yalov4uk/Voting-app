package com.yalovchuk.service.main.implementation.base;

import com.yalovchuk.bean.base.Bean;
import com.yalovchuk.service.main._interface.base.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public abstract class CrudServiceImpl<T extends Bean, K extends Number> implements CrudService<T, K> {

    protected abstract CrudRepository<T, K> getDao();

    @Override
    public T create(T bean) {
        return getDao().save(bean);
    }

    @Override
    public T read(K id) {
        return getDao().findOne(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T update(K id, T bean) {
        if (getDao().exists(id)) {
            bean.setId(id);
            return getDao().save(bean);
        }
        return null;
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
