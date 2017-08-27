package com.yalovchuk.service.main.implementation.base;

import com.yalovchuk.bean.base.NamedBean;
import com.yalovchuk.service.exception.NotFoundException;
import com.yalovchuk.service.exception.NotValidException;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.service.utils.validator._interface.base.NamedBeanValidator;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public abstract class CrudServiceImpl<T extends NamedBean<K>, K extends Number> implements CrudService<T, K> {

    protected abstract CrudRepository<T, K> getDao();

    protected abstract void loadLists(T oldBean, T newBean);

    protected abstract NamedBeanValidator<T, K> getValidator();

    @Override
    public T create(T bean) {
        if (!getValidator().validateId(bean) || !getValidator().validateName(bean)) throw new NotValidException();
        bean.setId(null);
        return getDao().save(bean);
    }

    @Override
    public T read(K id) {
        T bean = getDao().findOne(id);
        if (bean == null) throw new NotFoundException();
        return bean;
    }

    @Override
    public T update(K id, T newBean) {
        if (!getValidator().validateId(newBean) || !getValidator().validateName(newBean)) throw new NotValidException();
        T oldBean = getDao().findOne(id);
        if (oldBean == null) throw new NotFoundException();
        loadLists(oldBean, newBean);
        newBean.setId(id);
        return getDao().save(newBean);
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
