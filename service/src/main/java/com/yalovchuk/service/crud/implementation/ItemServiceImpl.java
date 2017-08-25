package com.yalovchuk.service.crud.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dao.ItemDao;
import com.yalovchuk.service.crud._interface.ItemService;
import com.yalovchuk.service.crud.implementation.base.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends CrudServiceImpl<Item, Long> implements ItemService {

    @Autowired
    protected ItemDao itemDao;

    protected CrudRepository<Item, Long> getDao() {
        return itemDao;
    }
}
