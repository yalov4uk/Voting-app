package com.yalovchuk.service.main.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dao.ItemDao;
import com.yalovchuk.dao.VotingDao;
import com.yalovchuk.service.main._interface.ItemService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends CrudServiceImpl<Item, Long> implements ItemService {

    @Autowired
    protected ItemDao itemDao;
    @Autowired
    protected VotingDao votingDao;

    protected CrudRepository<Item, Long> getDao() {
        return itemDao;
    }

    @Override
    public Item createByVotingId(Long votingId, Item item) {
        item.setVoting(votingDao.findOne(votingId));
        return create(item);
    }

    @Override
    public void deleteAllByVotingId(Long votingId) {
        itemDao.deleteAllByVotingId(votingId);
    }

    @Override
    public List<Item> getAllByVotingId(Long votingId) {
        return itemDao.getAllByVotingId(votingId);
    }
}
