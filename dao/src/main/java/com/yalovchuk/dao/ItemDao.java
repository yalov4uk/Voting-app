package com.yalovchuk.dao;

import com.yalovchuk.bean.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemDao extends CrudRepository<Item, Long> {

    void deleteAllByVotingId(Long votingId);

    List<Item> getAllByVotingId(Long votingId);
}
