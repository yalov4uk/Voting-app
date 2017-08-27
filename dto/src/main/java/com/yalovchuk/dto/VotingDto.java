package com.yalovchuk.dto;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.base.NamedBeanDto;

public class VotingDto extends NamedBeanDto<Voting, Long> {

    private Boolean enable;
    private Long topicId;

    public VotingDto() {
        super();
    }

    public VotingDto(Long id, String name, Boolean enable, Long topicId) {
        super(id, name);
        this.enable = enable;
        this.topicId = topicId;
    }

    public VotingDto(Voting voting) {
        super(voting);
        this.enable = voting.getEnable();
        this.topicId = voting.getTopic().getId();
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }
}
