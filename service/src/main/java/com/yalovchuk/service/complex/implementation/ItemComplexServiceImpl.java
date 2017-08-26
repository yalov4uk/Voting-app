package com.yalovchuk.service.complex.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dao.ItemDao;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.complex._interface.ItemComplexService;
import com.yalovchuk.service.main.implementation.ItemServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemComplexServiceImpl extends ItemServiceImpl implements ItemComplexService {

    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public Item dtoToBean(ItemDto beanDto) {
        return null;
    }

    @Override
    public ItemResource beanToResource(Item bean) {
        return null;
    }

    @Override
    public ItemResource createResourceByVotingId(Long votingId, ItemDto itemDto) {
        Item item = dtoToBean(itemDto);
        item = super.createByVotingId(votingId, item);
        return beanToResource(item);
    }

    @Override
    public void deleteAllResourcesByVotingId(Long votingId) {
        super.deleteAllByVotingId(votingId);
    }

    @Override
    public List<ItemResource> getAllResourcesByVotingId(Long votingId) {
        List<Item> items = super.getAllByVotingId(votingId);
        return items.stream().map(this::beanToResource).collect(Collectors.toList());
    }
}
