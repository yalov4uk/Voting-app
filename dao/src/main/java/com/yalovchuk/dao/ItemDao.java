package com.yalovchuk.dao;

import com.yalovchuk.bean.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ItemDao extends CrudRepository<Item, Long> {
}
