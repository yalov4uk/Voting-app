package com.yalovchuk.service.complex.implementation;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dto.TopicDto;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.service.complex._interface.TopicComplexService;
import com.yalovchuk.service.main.implementation.TopicServiceImpl;
import com.yalovchuk.service.utils.mapper._interface.TopicMapper;
import com.yalovchuk.service.utils.mapper._interface.base.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicComplexServiceImpl extends TopicServiceImpl implements TopicComplexService {

    @Autowired
    protected TopicMapper topicMapper;

    @Override
    public Mapper<Topic, Long, TopicDto, TopicResource> getMapper() {
        return topicMapper;
    }
}
