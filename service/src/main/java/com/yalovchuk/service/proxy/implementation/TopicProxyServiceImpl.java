package com.yalovchuk.service.proxy.implementation;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dto.TopicDto;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.service.main._interface.TopicService;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.service.proxy._interface.TopicProxyService;
import com.yalovchuk.service.proxy.implementation.base.CrudProxyServiceImpl;
import com.yalovchuk.service.utility.mapper._interface.TopicMapper;
import com.yalovchuk.service.utility.mapper._interface.base.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class TopicProxyServiceImpl extends CrudProxyServiceImpl<Topic, Long, TopicDto, TopicResource>
        implements TopicProxyService {

    @Autowired
    private TopicService topicService;

    @Autowired
    private TopicMapper topicMapper;

    @Override
    protected CrudService<Topic, Long> getService() {
        return topicService;
    }

    @Override
    public Mapper<Topic, Long, TopicDto, TopicResource> getMapper() {
        return topicMapper;
    }
}
