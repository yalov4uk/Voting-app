package com.yalovchuk.service.main._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.service.main._interface.base.CrudService;

import java.util.List;

public interface ItemService extends CrudService<Item, Long> {

    Item createByVotingId(Long votingId, Item item);

    void deleteAllByVotingId(Long votingId);

    List<Item> getAllByVotingId(Long votingId);
}
