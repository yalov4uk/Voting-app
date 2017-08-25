package com.yalovchuk.service.main.implementation;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dao.TopicDao;
import com.yalovchuk.service.main._interface.TopicService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl extends CrudServiceImpl<Topic, Long> implements TopicService {

    @Autowired
    protected TopicDao topicDao;

    protected CrudRepository<Topic, Long> getDao() {
        return topicDao;
    }
}
