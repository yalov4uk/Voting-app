package com.yalovchuk.service.main.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.ItemDao;
import com.yalovchuk.dao.VotingDao;
import com.yalovchuk.service.exception.NotFoundException;
import com.yalovchuk.service.exception.NotValidException;
import com.yalovchuk.service.main._interface.ItemService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import com.yalovchuk.service.utils.validator._interface.ItemValidator;
import com.yalovchuk.service.utils.validator._interface.base.NamedBeanValidator;
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
        if (!itemValidator.validateScore(bean)) throw new NotValidException();
        return super.create(bean);
    }

    @Override
    public Item update(Long id, Item newBean) {
        if (!itemValidator.validateScore(newBean)) throw new NotValidException();
        return super.update(id, newBean);
    }

    @Override
    public Item createByVotingId(Long votingId, Item item) {
        Voting voting = votingDao.findOne(votingId);
        if (voting == null) throw new NotFoundException();
        item.setVoting(voting);
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
