package com.yalovchuk.service.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dao.ItemDao;
import com.yalovchuk.service._interface.ItemService;
import com.yalovchuk.service.implementation.base.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class ItemServiceImpl extends CrudServiceImpl<Item, Long> implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    protected CrudRepository<Item, Long> getDao() {
        return itemDao;
    }
}
