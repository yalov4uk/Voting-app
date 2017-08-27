package com.yalovchuk.service.complex.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.complex._interface.ItemComplexService;
import com.yalovchuk.service.main.implementation.ItemServiceImpl;
import com.yalovchuk.service.utils.mapper._interface.ItemMapper;
import com.yalovchuk.service.utils.mapper._interface.base.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemComplexServiceImpl extends ItemServiceImpl implements ItemComplexService {

    @Autowired
    protected ItemMapper itemMapper;

    @Override
    public Mapper<Item, Long, ItemDto, ItemResource> getMapper() {
        return itemMapper;
    }

    @Override
    public ItemResource createResourceByVotingId(Long votingId, ItemDto itemDto) {
        Item item = itemMapper.dtoToBean(itemDto);
        item = super.createByVotingId(votingId, item);
        return itemMapper.beanToResource(item);
    }

    @Override
    public void deleteAllResourcesByVotingId(Long votingId) {
        super.deleteAllByVotingId(votingId);
    }

    @Override
    public List<ItemResource> getAllResourcesByVotingId(Long votingId) {
        List<Item> items = super.getAllByVotingId(votingId);
        return items.stream().map(this.itemMapper::beanToResource).collect(Collectors.toList());
    }
}
