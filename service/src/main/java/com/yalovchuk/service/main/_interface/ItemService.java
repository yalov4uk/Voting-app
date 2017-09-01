package com.yalovchuk.service.main._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.service.main._interface.base.CrudService;

public interface ItemService extends CrudService<Item, Long> {

    void registerItem(Long itemId);
}
