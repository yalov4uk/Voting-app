package com.yalovchuk.service.main._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.service.main._interface.base.CrudService;

import java.util.List;

public interface ItemService extends CrudService<Item, Long> {

    Item createByTopicIdAndVotingId(Item item, Long topicId, Long votingId);

    Item readByTopicIdAndVotingIdAndId(Long topicId, Long votingId, Long itemId);

    Item updateByTopicIdAndVotingIdAndId(Item item, Long topicId, Long votingId, Long itemId);

    void deleteByTopicIdAndVotingIdAndId(Long topicId, Long votingId, Long itemId);

    void deleteAllByTopicIdAndVotingId(Long topicId, Long votingId);

    List<Item> getAllByTopicIdAndVotingId(Long topicId, Long votingId);
}
