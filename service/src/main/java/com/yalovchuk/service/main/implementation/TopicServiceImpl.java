package com.yalovchuk.service.main.implementation;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dao.TopicDao;
import com.yalovchuk.service.main._interface.TopicService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import com.yalovchuk.service.utility.validator._interface.TopicValidator;
import com.yalovchuk.service.utility.validator._interface.base.NamedBeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl extends CrudServiceImpl<Topic, Long> implements TopicService {

    @Autowired
    private TopicDao topicDao;
    @Autowired
    private TopicValidator topicValidator;

    protected CrudRepository<Topic, Long> getDao() {
        return topicDao;
    }

    @Override
    protected void loadLists(Topic oldTopic, Topic newTopic) {
        newTopic.setVotings(oldTopic.getVotings());
    }

    @Override
    protected NamedBeanValidator<Topic, Long> getValidator() {
        return topicValidator;
    }
}
