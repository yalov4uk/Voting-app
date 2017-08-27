package com.yalovchuk.service.proxy._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.proxy._interface.base.CrudProxyService;

import java.util.List;

public interface ItemProxyService extends CrudProxyService<Item, Long, ItemDto, ItemResource> {

    ItemResource createByVotingId(Long votingId, ItemDto itemDto);

    void deleteAllByVotingId(Long votingId);

    List<ItemResource> getAllByVotingId(Long votingId);
}
