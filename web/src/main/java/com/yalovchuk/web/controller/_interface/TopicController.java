package com.yalovchuk.web.controller._interface;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dto.TopicDto;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.web.controller._interface.base.mixin.*;

public interface TopicController extends
        CreateController<Topic, Long, TopicDto, TopicResource>,
        ReadController<Topic, Long, TopicDto, TopicResource>,
        UpdateController<Topic, Long, TopicDto, TopicResource>,
        DeleteController<Topic, Long, TopicDto, TopicResource>,
        GetAllController<Topic, Long, TopicDto, TopicResource> {
}
