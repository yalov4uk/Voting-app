package com.yalovchuk.service.complex.implementation;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dto.TopicDto;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.service.complex._interface.TopicComplexService;
import com.yalovchuk.service.main.implementation.TopicServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicComplexServiceImpl extends TopicServiceImpl implements TopicComplexService {

    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public Topic dtoToBean(TopicDto beanDto) {
        Topic topic = modelMapper.map(beanDto, Topic.class);
        return topic;
    }

    @Override
    public TopicResource beanToResource(Topic bean) {
        return modelMapper.map(bean, TopicResource.class);
    }
}
