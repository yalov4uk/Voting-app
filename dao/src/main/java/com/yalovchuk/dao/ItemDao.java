package com.yalovchuk.dao;

import com.yalovchuk.bean.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDao extends CrudRepository<Item, Long> {
}
