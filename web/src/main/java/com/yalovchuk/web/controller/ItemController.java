package com.yalovchuk.web.controller;

import com.yalovchuk.bean.Item;
import com.yalovchuk.service.crud._interface.ItemService;
import com.yalovchuk.service.crud._interface.base.CrudService;
import com.yalovchuk.web.controller.base.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Deprecated
@RestController
@RequestMapping(value = "/items")
public class ItemController extends CrudController<Item, Long> {

    @Autowired
    private ItemService itemService;

    @Override
    protected CrudService<Item, Long> getService() {
        return itemService;
    }
}
