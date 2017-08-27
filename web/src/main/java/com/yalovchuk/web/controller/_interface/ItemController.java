package com.yalovchuk.web.controller._interface;

import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ItemController {

    HttpEntity<ItemResource> createItemByTopicIdAndVotingId(ItemDto itemDto, Long topicId, Long votingId);

    HttpEntity<ItemResource> readItemByTopicIdAndVotingIdAndId(Long topicId, Long votingId, Long itemId);

    HttpEntity<ItemResource> updateItemByTopicIdAndVotingIdAndId(ItemDto itemDto, Long topicId, Long votingId, Long itemId);

    HttpStatus deleteAllItemsByTopicIdAndVotingId(Long topicId, Long votingId, Long itemId);

    HttpStatus deleteAllItemsByTopicIdAndVotingId(Long topicId, Long votingId);

    HttpEntity<List<ItemResource>> getAllItemsByTopicIdAndVotingId(Long topicId, Long votingId);

    HttpStatus registerItem(Long topicId, Long votingId, Long itemId);
}
