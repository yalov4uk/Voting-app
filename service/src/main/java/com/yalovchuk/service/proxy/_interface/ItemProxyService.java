package com.yalovchuk.service.proxy._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.proxy._interface.base.CrudProxyService;

public interface ItemProxyService extends CrudProxyService<Item, Long, ItemDto, ItemResource> {

    void registerItem(Long itemId);
}
