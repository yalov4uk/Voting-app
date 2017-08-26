package com.yalovchuk.service.complex.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dao.ItemDao;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.complex._interface.ItemComplexService;
import com.yalovchuk.service.complex.implementation.base.CrudComplexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemComplexServiceImpl extends CrudComplexServiceImpl<Item, Long, ItemDto, ItemResource> implements
        ItemComplexService {

    @Autowired
    protected ItemDao itemDao;

    @Override
    protected Class<Item> getBeanClass() {
        return Item.class;
    }

    @Override
    protected Class<ItemDto> getDtoClass() {
        return ItemDto.class;
    }

    @Override
    protected Class<ItemResource> getResourceClass() {
        return ItemResource.class;
    }

    @Override
    protected CrudRepository<Item, Long> getDao() {
        return itemDao;
    }
}
