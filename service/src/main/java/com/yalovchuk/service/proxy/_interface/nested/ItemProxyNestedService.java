package com.yalovchuk.service.proxy._interface.nested;

import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;

import java.util.List;

public interface ItemProxyNestedService {

    ItemResource createByTopicIdAndVotingId(ItemDto itemDto, Long topicId, Long votingId);

    void deleteAllByTopicIdAndVotingId(Long topicId, Long votingId);

    List<ItemResource> getAllByTopicIdAndVotingId(Long topicId, Long votingId);
}
