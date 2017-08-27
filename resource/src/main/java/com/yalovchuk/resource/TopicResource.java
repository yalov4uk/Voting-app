package com.yalovchuk.resource;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.resource.base.NamedBeanResource;

public class TopicResource extends NamedBeanResource<Topic, Long> {

    public TopicResource() {
        super();
    }

    public TopicResource(Long id, String name) {
        super(id, name);
    }

    public TopicResource(Topic topic) {
        super(topic);
    }
}
