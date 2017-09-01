package com.yalovchuk.service.main._interface.nested;

import com.yalovchuk.bean.Item;

import java.util.List;

public interface ItemNestedService {

    Item createByTopicIdAndVotingId(Item item, Long topicId, Long votingId);

    void deleteAllByTopicIdAndVotingId(Long topicId, Long votingId);

    List<Item> getAllByTopicIdAndVotingId(Long topicId, Long votingId);
}
