package com.yalovchuk.resource;

import com.yalovchuk.bean.Item;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.resource.base.BaseNamedResource;

public class ItemResource extends BaseNamedResource<Item, Long> {

    private Integer score;
    private Voting voting;

    public ItemResource(Long pk, String name, Integer score, Voting voting) {
        super(pk, name);
        this.score = score;
        this.voting = voting;
    }

    public ItemResource(Item item) {
        super(item);
        this.score = item.getScore();
        this.voting = item.getVoting();
    }

    public Integer getScore() {
        return score;
    }

    public Voting getVoting() {
        return voting;
    }
}
