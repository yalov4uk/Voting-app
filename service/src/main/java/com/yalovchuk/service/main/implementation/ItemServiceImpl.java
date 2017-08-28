package com.yalovchuk.service.main.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.ItemDao;
import com.yalovchuk.service.exception.ForbiddenException;
import com.yalovchuk.service.exception.NotFoundException;
import com.yalovchuk.service.exception.NotValidException;
import com.yalovchuk.service.main._interface.ItemService;
import com.yalovchuk.service.main._interface.VotingService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import com.yalovchuk.service.utility.validator._interface.ItemValidator;
import com.yalovchuk.service.utility.validator._interface.base.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends CrudServiceImpl<Item, Long> implements ItemService {

    @Autowired
    private ItemDao itemDao;
    @Autowired
    private VotingService votingService;
    @Autowired
    private ItemValidator itemValidator;

    protected CrudRepository<Item, Long> getDao() {
        return itemDao;
    }

    @Override
    protected void loadLists(Item oldItem, Item newItem) {
    }

    @Override
    protected BeanValidator<Item, Long> getValidator() {
        return itemValidator;
    }

    @Override
    public Item create(Item item) {
        if (!itemValidator.validateName(item)) throw new NotValidException();
        item.setScore(0);
        return super.create(item);
    }

    @Override
    public Item update(Item newItem, Long id) {
        if (!itemValidator.validateName(newItem)) throw new NotValidException();
        newItem.setScore(read(id).getScore());
        return super.update(newItem, id);
    }

    @Override
    public Item createByTopicIdAndVotingId(Item item, Long topicId, Long votingId) {
        Voting voting = votingService.readByTopicIdAndId(topicId, votingId);
        item.setVoting(voting);
        return create(item);
    }

    @Override
    public Item readByTopicIdAndVotingIdAndId(Long topicId, Long votingId, Long itemId) {
        Item item = itemDao.readByVotingTopicIdAndVotingIdAndId(topicId, votingId, itemId);
        if (item == null) throw new NotFoundException();
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
        return itemDao.getAllByVotingTopicIdAndVotingId(topicId, votingId);
    }

    @Override
    public void registerItem(Long topicId, Long votingId, Long itemId) {
        Item item = itemDao.readByVotingTopicIdAndVotingIdAndIdAndVotingEnableTrue(topicId, votingId, itemId);
        if (item == null) throw new ForbiddenException();
        item.incScore();
    }
}
