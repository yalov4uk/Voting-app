package com.yalovchuk.service.main.implementation;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dao.TopicDao;
import com.yalovchuk.service.main._interface.TopicService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import com.yalovchuk.service.utils.validator._interface.TopicValidator;
import com.yalovchuk.service.utils.validator._interface.base.NamedBeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl extends CrudServiceImpl<Topic, Long> implements TopicService {

    @Autowired
    protected TopicDao topicDao;
    @Autowired
    protected TopicValidator topicValidator;

    protected CrudRepository<Topic, Long> getDao() {
        return topicDao;
    }

    @Override
    protected void loadLists(Topic oldBean, Topic newBean) {
        newBean.setVotings(oldBean.getVotings());
    }

    @Override
    protected NamedBeanValidator<Topic, Long> getValidator() {
        return topicValidator;
    }
}
