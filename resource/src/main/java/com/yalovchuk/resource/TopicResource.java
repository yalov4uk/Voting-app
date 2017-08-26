package com.yalovchuk.resource;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.resource.base.NamedBeanResource;

public class TopicResource extends NamedBeanResource<Topic, Long> {

    public TopicResource(Long pk, String name) {
        super(pk, name);
    }

    public TopicResource(Topic topic) {
        super(topic);
    }
}
