package com.yalovchuk.resource;

import com.yalovchuk.bean.Item;
import com.yalovchuk.resource.base.NamedBeanResource;

public class ItemResource extends NamedBeanResource<Item, Long> {

    private Integer score;
    private VotingResource voting;

    public ItemResource() {
        super();
    }

    public ItemResource(Long id, String name, Integer score, VotingResource voting) {
        super(id, name);
        this.score = score;
        this.voting = voting;
    }

    public ItemResource(Item item, VotingResource voting) {
        super(item);
        this.score = item.getScore();
        this.voting = voting;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public VotingResource getVoting() {
        return voting;
    }

    public void setVoting(VotingResource voting) {
        this.voting = voting;
    }
}
