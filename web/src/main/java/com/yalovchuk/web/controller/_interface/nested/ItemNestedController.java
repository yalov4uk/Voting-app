package com.yalovchuk.web.controller._interface.nested;

import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ItemNestedController {

    HttpEntity<ItemResource> createItemByTopicIdAndVotingId(ItemDto itemDto, Long topicId, Long votingId);

    HttpStatus deleteAllItemsByTopicIdAndVotingId(Long topicId, Long votingId);

    HttpEntity<List<ItemResource>> getAllItemsByTopicIdAndVotingId(Long topicId, Long votingId);
}
