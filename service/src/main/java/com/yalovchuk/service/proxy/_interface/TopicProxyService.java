package com.yalovchuk.service.proxy._interface;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dto.TopicDto;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.service.proxy._interface.base.CrudProxyService;

public interface TopicProxyService extends CrudProxyService<Topic, Long, TopicDto, TopicResource> {
}
