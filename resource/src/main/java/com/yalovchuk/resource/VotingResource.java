package com.yalovchuk.resource;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yalovchuk.bean.Topic;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.resource.base.BaseNamedResource;

public class VotingResource extends BaseNamedResource<Voting, Long> {

    private Boolean enable;
    private Topic topic;

    public VotingResource(Long pk, String name, Boolean enable, Topic topic) {
        super(pk, name);
        this.enable = enable;
        this.topic = topic;
    }

    public VotingResource(Voting voting) {
        super(voting);
        this.enable = voting.getEnable();
        this.topic = voting.getTopic();
    }

    public Boolean getEnable() {
        return enable;
    }

    public Topic getTopic() {
        return topic;
    }
}
