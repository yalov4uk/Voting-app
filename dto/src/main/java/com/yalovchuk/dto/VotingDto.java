package com.yalovchuk.dto;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.base.NamedBeanDto;

public class VotingDto extends NamedBeanDto<Voting, Long> {

    private Boolean enable;
    private Topic topic;

    public VotingDto(Long id, String name, Boolean enable, Topic topic) {
        super(id, name);
        this.enable = enable;
        this.topic = topic;
    }

    public VotingDto(Voting voting) {
        super(voting);
        this.enable = voting.getEnable();
        this.topic = voting.getTopic();
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
