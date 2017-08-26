package com.yalovchuk.service.complex._interface;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dto.TopicDto;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.service.complex._interface.base.CrudComplexService;

public interface TopicComplexService extends CrudComplexService<Topic, Long, TopicDto, TopicResource> {
}
