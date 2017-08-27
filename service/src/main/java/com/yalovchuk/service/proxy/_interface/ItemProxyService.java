package com.yalovchuk.service.proxy._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.proxy._interface.base.CrudProxyService;

import java.util.List;

public interface ItemProxyService extends CrudProxyService<Item, Long, ItemDto, ItemResource> {

    ItemResource createByTopicIdAndVotingId(ItemDto itemDto, Long topicId, Long votingId);

    ItemResource readByTopicIdAndVotingIdAndId(Long topicId, Long votingId, Long itemId);

    ItemResource updateByTopicIdAndVotingIdAndId(ItemDto itemDto, Long topicId, Long votingId, Long itemId);

    void deleteByTopicIdAndVotingIdAndId(Long topicId, Long votingId, Long itemId);

    void deleteAllByTopicIdAndVotingId(Long topicId, Long votingId);

    List<ItemResource> getAllByTopicIdAndVotingId(Long topicId, Long votingId);
}
