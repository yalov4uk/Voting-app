package com.yalovchuk.service.implementation;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dao.TopicDao;
import com.yalovchuk.service._interface.TopicService;
import com.yalovchuk.service.implementation.base.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class TopicServiceImpl extends CrudServiceImpl<Topic, Long> implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Override
    protected CrudRepository<Topic, Long> getDao() {
        return topicDao;
    }
}
