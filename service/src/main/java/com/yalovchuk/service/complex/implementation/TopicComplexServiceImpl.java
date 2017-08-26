package com.yalovchuk.service.complex.implementation;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dao.TopicDao;
import com.yalovchuk.dto.TopicDto;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.service.complex._interface.TopicComplexService;
import com.yalovchuk.service.main.implementation.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicComplexServiceImpl extends TopicServiceImpl implements TopicComplexService {

    @Override
    public Topic dtoToBean(TopicDto beanDto) {
        return null;
    }

    @Override
    public TopicResource beanToResource(Topic bean) {
        return null;
    }
}
