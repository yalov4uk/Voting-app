package com.yalovchuk.dto;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dto.base.NamedBeanDto;

public class TopicDto extends NamedBeanDto<Topic, Long> {

    public TopicDto(Long id, String name) {
        super(id, name);
    }

    public TopicDto(Topic topic) {
        super(topic);
    }
}
