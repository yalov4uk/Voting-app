package com.yalovchuk.service.complex._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.complex._interface.mixin.CrudComplexService;

import java.util.List;

public interface ItemComplexService extends CrudComplexService<Item, Long, ItemDto, ItemResource> {

    ItemResource createResourceByVotingId(Long votingId, ItemDto itemDto);

    void deleteAllResourcesByVotingId(Long votingId);

    List<ItemResource> getAllResourcesByVotingId(Long votingId);
}
