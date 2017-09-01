package com.yalovchuk.service.main.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dao.ItemDao;
import com.yalovchuk.service.exception.ForbiddenException;
import com.yalovchuk.service.exception.NotValidException;
import com.yalovchuk.service.main._interface.ItemService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import com.yalovchuk.service.utility.validator._interface.ItemValidator;
import com.yalovchuk.service.utility.validator._interface.base.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ItemServiceImpl extends CrudServiceImpl<Item, Long> implements ItemService {

    @Autowired
    private ItemDao itemDao;
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
        if (!itemValidator.validateName(item) || !itemValidator.validateVoting(item)) throw new NotValidException();
        item.setScore(0);
        return super.create(item);
    }

    @Override
    public Item update(Item newItem, Long id) {
        if (!itemValidator.validateName(newItem) || !itemValidator.validateVoting(newItem))
            throw new NotValidException();
        newItem.setScore(read(id).getScore());
        return super.update(newItem, id);
    }

    @Override
    public void registerItem(Long itemId) {
        Item item = itemDao.readByIdAndVotingEnableTrue(itemId);
        if (Objects.isNull(item)) throw new ForbiddenException();
        item.incScore();
    }
}
