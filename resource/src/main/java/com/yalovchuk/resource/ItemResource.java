package com.yalovchuk.resource;

import com.yalovchuk.bean.Item;
import com.yalovchuk.resource.base.NamedBeanResource;

public class ItemResource extends NamedBeanResource<Item, Long> {

    private Integer score;
    private VotingResource voting;

    public ItemResource(Long pk, String name, Integer score, VotingResource voting) {
        super(pk, name);
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

    public VotingResource getVoting() {
        return voting;
    }
}
