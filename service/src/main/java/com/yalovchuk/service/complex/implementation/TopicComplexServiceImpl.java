package com.yalovchuk.service.complex.implementation;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dao.TopicDao;
import com.yalovchuk.dto.TopicDto;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.service.complex._interface.TopicComplexService;
import com.yalovchuk.service.complex.implementation.base.CrudComplexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicComplexServiceImpl extends CrudComplexServiceImpl<Topic, Long, TopicDto, TopicResource> implements
        TopicComplexService {

    @Autowired
    protected TopicDao topicDao;

    @Override
    protected Class<Topic> getBeanClass() {
        return Topic.class;
    }

    @Override
    protected Class<TopicDto> getDtoClass() {
        return TopicDto.class;
    }

    @Override
    protected Class<TopicResource> getResourceClass() {
        return TopicResource.class;
    }

    @Override
    protected CrudRepository<Topic, Long> getDao() {
        return topicDao;
    }
}
