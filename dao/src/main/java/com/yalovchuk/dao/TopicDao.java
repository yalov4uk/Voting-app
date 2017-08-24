package com.yalovchuk.dao;

import com.yalovchuk.bean.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicDao extends CrudRepository<Topic, Long> {
}
