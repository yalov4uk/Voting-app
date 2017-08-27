package com.yalovchuk.service.main.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.ItemDao;
import com.yalovchuk.service.exception.NotFoundException;
import com.yalovchuk.service.main._interface.ItemService;
import com.yalovchuk.service.main._interface.VotingService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import com.yalovchuk.service.utility.validator._interface.ItemValidator;
import com.yalovchuk.service.utility.validator._interface.base.NamedBeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ItemServiceImpl extends CrudServiceImpl<Item, Long> implements ItemService {

    @Autowired
    protected ItemDao itemDao;
    @Autowired
    protected VotingService votingService;
    @Autowired
    protected ItemValidator itemValidator;

    protected CrudRepository<Item, Long> getDao() {
        return itemDao;
    }

    @Override
    protected void loadLists(Item oldBean, Item newBean) {
    }

    @Override
    protected NamedBeanValidator<Item, Long> getValidator() {
        return itemValidator;
    }

    @Override
    public Item create(Item bean) {
        bean.setScore(0);
        return super.create(bean);
    }

    @Override
    public Item read(Long id) {
        Item item = itemDao.findByIdAndVotingEnableTrue(id);
        if (item == null) throw new NotFoundException();
        return item;
    }

    @Override
    public Item update(Item newBean, Long id) {
        newBean.setScore(itemDao.findOne(id).getScore());
        return super.update(newBean, id);
    }

    @Override
    public Item createByTopicIdAndVotingId(Item item, Long topicId, Long votingId) {
        Voting voting = votingService.readByTopicIdAndId(topicId, votingId);
        item.setVoting(voting);
        return create(item);
    }

    @Override
    public Item readByTopicIdAndVotingIdAndId(Long topicId, Long votingId, Long itemId) {
        Item item = read(itemId);
        if (item.getVoting() == null || !Objects.equals(item.getVoting().getId(), votingId)
                || item.getVoting().getTopic() == null
                || !Objects.equals(item.getVoting().getTopic().getId(), topicId))
            throw new NotFoundException();
        return item;
    }

    @Override
    public Item updateByTopicIdAndVotingIdAndId(Item newItem, Long topicId, Long votingId, Long itemId) {
        readByTopicIdAndVotingIdAndId(topicId, votingId, itemId);
        return update(newItem, votingId);
    }

    @Override
    public void deleteByTopicIdAndVotingIdAndId(Long topicId, Long votingId, Long itemId) {
        itemDao.deleteByVotingTopicIdAndVotingIdAndId(topicId, votingId, itemId);
    }

    @Override
    public void deleteAllByTopicIdAndVotingId(Long topicId, Long votingId) {
        itemDao.deleteAllByVotingTopicIdAndVotingId(topicId, votingId);
    }

    @Override
    public List<Item> getAllByTopicIdAndVotingId(Long topicId, Long votingId) {
        return itemDao.getAllByVotingTopicIdAndVotingIdAndVotingEnableTrue(topicId, votingId);
    }

    @Override
    public void registerItem(Long topicId, Long votingId, Long itemId) {
        Item item = readByTopicIdAndVotingIdAndId(topicId, votingId, itemId);
        item.incScore();
    }
}
