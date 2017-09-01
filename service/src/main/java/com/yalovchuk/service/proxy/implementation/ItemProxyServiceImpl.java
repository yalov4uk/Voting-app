package com.yalovchuk.service.proxy.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.main._interface.ItemService;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.service.proxy._interface.ItemProxyService;
import com.yalovchuk.service.proxy.implementation.base.CrudProxyServiceImpl;
import com.yalovchuk.service.utility.mapper._interface.ItemMapper;
import com.yalovchuk.service.utility.mapper._interface.base.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ItemProxyServiceImpl extends CrudProxyServiceImpl<Item, Long, ItemDto, ItemResource>
        implements ItemProxyService {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    protected CrudService<Item, Long> getService() {
        return itemService;
    }

    @Override
    public Mapper<Item, Long, ItemDto, ItemResource> getMapper() {
        return itemMapper;
    }

    @Override
    public void registerItem(Long itemId) {
        itemService.registerItem(itemId);
    }
}
