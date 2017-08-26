package com.yalovchuk.dto;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.base.NamedBeanDto;

public class VotingDto extends NamedBeanDto<Voting, Long> {

    private Boolean enable;
    private TopicDto topic;

    public VotingDto(Long id, String name, Boolean enable, TopicDto topic) {
        super(id, name);
        this.enable = enable;
        this.topic = topic;
    }

    public VotingDto(Voting voting, TopicDto topic) {
        super(voting);
        this.enable = voting.getEnable();
        this.topic = topic;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public TopicDto getTopic() {
        return topic;
    }

    public void setTopic(TopicDto topic) {
        this.topic = topic;
    }
}
