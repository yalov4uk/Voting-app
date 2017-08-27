package com.yalovchuk.service.proxy.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.main._interface.ItemService;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.service.proxy._interface.ItemProxyService;
import com.yalovchuk.service.proxy.implementation.base.CrudProxyService;
import com.yalovchuk.service.utils.mapper._interface.ItemMapper;
import com.yalovchuk.service.utils.mapper._interface.base.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemProxyServiceImpl extends CrudProxyService<Item, Long, ItemDto, ItemResource>
        implements ItemProxyService {

    @Autowired
    protected ItemService itemService;

    @Autowired
    protected ItemMapper itemMapper;

    @Override
    protected CrudService<Item, Long> getService() {
        return itemService;
    }

    @Override
    public Mapper<Item, Long, ItemDto, ItemResource> getMapper() {
        return itemMapper;
    }

    @Override
    public ItemResource createByVotingId(Long votingId, ItemDto itemDto) {
        Item item = itemMapper.dtoToBean(itemDto);
        item = itemService.createByVotingId(votingId, item);
        return itemMapper.beanToResource(item);
    }

    @Override
    public void deleteAllByVotingId(Long votingId) {
        itemService.deleteAllByVotingId(votingId);
    }

    @Override
    public List<ItemResource> getAllByVotingId(Long votingId) {
        List<Item> items = itemService.getAllByVotingId(votingId);
        return items.stream().map(this.itemMapper::beanToResource).collect(Collectors.toList());
    }
}
