package com.yalovchuk.service.main.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dao.ItemDao;
import com.yalovchuk.service.main._interface.ItemService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends CrudServiceImpl<Item, Long> implements ItemService {

    @Autowired
    private ItemDao itemDao;


    protected CrudRepository<Item, Long> getDao() {
        return itemDao;
    }
}
