package com.yalovchuk.resource;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.resource.base.BaseNamedResource;

public class TopicResource extends BaseNamedResource<Topic, Long> {

    public TopicResource(Long pk, String name) {
        super(pk, name);
    }

    public TopicResource(Topic topic) {
        super(topic);
    }
}
