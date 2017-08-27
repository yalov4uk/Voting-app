package com.yalovchuk.service.proxy.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.main._interface.ItemService;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.service.proxy._interface.ItemProxyService;
import com.yalovchuk.service.proxy.implementation.base.CrudProxyService;
import com.yalovchuk.service.utility.mapper._interface.ItemMapper;
import com.yalovchuk.service.utility.mapper._interface.base.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
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
    public ItemResource createByTopicIdAndVotingId(ItemDto itemDto, Long topicId, Long votingId) {
        Item item = itemMapper.dtoToBean(itemDto);
        item = itemService.createByTopicIdAndVotingId(item, topicId, votingId);
        return itemMapper.beanToResource(item);
    }

    @Override
    public ItemResource readByTopicIdAndVotingIdAndId(Long topicId, Long votingId, Long itemId) {
        Item item = itemService.readByTopicIdAndVotingIdAndId(topicId, votingId, itemId);
        return itemMapper.beanToResource(item);
    }

    @Override
    public ItemResource updateByTopicIdAndVotingIdAndId(ItemDto itemDto, Long topicId, Long votingId, Long itemId) {
        Item item = itemMapper.dtoToBean(itemDto);
        item = itemService.updateByTopicIdAndVotingIdAndId(item, topicId, votingId, itemId);
        return itemMapper.beanToResource(item);
    }

    @Override
    public void deleteByTopicIdAndVotingIdAndId(Long topicId, Long votingId, Long itemId) {
        itemService.deleteByTopicIdAndVotingIdAndId(topicId, votingId, itemId);
    }

    @Override
    public void deleteAllByTopicIdAndVotingId(Long topicId, Long votingId) {
        itemService.deleteAllByTopicIdAndVotingId(topicId, votingId);
    }

    @Override
    public List<ItemResource> getAllByTopicIdAndVotingId(Long topicId, Long votingId) {
        List<Item> items = itemService.getAllByTopicIdAndVotingId(topicId, votingId);
        return items.stream().map(this.itemMapper::beanToResource).collect(Collectors.toList());
    }

    @Override
    public void registerItem(Long topicId, Long votingId, Long itemId) {
        itemService.registerItem(topicId, votingId, itemId);
    }
}
