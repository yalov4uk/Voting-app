package com.yalovchuk.service.proxy.implementation.nested;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.main._interface.nested.ItemNestedService;
import com.yalovchuk.service.proxy._interface.nested.ItemProxyNestedService;
import com.yalovchuk.service.utility.mapper._interface.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemProxyNestedServiceImpl implements ItemProxyNestedService {

    @Autowired
    private ItemNestedService itemNestedService;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public ItemResource createByTopicIdAndVotingId(ItemDto itemDto, Long topicId, Long votingId) {
        itemDto.setVotingId(null);
        Item item = itemMapper.dtoToBean(itemDto);
        item = itemNestedService.createByTopicIdAndVotingId(item, topicId, votingId);
        return itemMapper.beanToResource(item);
    }

    @Override
    public void deleteAllByTopicIdAndVotingId(Long topicId, Long votingId) {
        itemNestedService.deleteAllByTopicIdAndVotingId(topicId, votingId);
    }

    @Override
    public List<ItemResource> getAllByTopicIdAndVotingId(Long topicId, Long votingId) {
        List<Item> items = itemNestedService.getAllByTopicIdAndVotingId(topicId, votingId);
        return items.stream().map(this.itemMapper::beanToResource).collect(Collectors.toList());
    }

}
