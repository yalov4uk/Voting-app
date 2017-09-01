package com.yalovchuk.service.main.implementation.nested;

import com.yalovchuk.bean.Item;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.ItemDao;
import com.yalovchuk.dao.VotingDao;
import com.yalovchuk.service.exception.NotFoundException;
import com.yalovchuk.service.main._interface.ItemService;
import com.yalovchuk.service.main._interface.nested.ItemNestedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ItemNestedServiceImpl implements ItemNestedService {

    @Autowired
    private ItemDao itemDao;
    @Autowired
    private VotingDao votingDao;
    @Autowired
    private ItemService itemService;

    @Override
    public Item createByTopicIdAndVotingId(Item item, Long topicId, Long votingId) {
        Voting voting = votingDao.readByTopicIdAndId(topicId, votingId);
        if (Objects.isNull(voting)) throw new NotFoundException();
        item.setVoting(voting);
        return itemService.create(item);
    }

    @Override
    public void deleteAllByTopicIdAndVotingId(Long topicId, Long votingId) {
        itemDao.deleteAllByVotingTopicIdAndVotingId(topicId, votingId);
    }

    @Override
    public List<Item> getAllByTopicIdAndVotingId(Long topicId, Long votingId) {
        return itemDao.getAllByVotingTopicIdAndVotingId(topicId, votingId);
    }
}
