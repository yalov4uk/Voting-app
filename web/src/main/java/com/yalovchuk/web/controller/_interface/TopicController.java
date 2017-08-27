package com.yalovchuk.web.controller._interface;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dto.TopicDto;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.web.controller._interface.base.CrudController;

public interface TopicController extends CrudController<Topic, Long, TopicDto, TopicResource> {
}
