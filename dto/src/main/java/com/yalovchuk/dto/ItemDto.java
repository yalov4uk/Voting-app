package com.yalovchuk.dto;

import com.yalovchuk.bean.Item;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.base.NamedBeanDto;

public class ItemDto extends NamedBeanDto<Item, Long> {

    private Integer score;
    private Voting voting;

    public ItemDto(Long id, String name, Integer score, Voting voting) {
        super(id, name);
        this.score = score;
        this.voting = voting;
    }

    public ItemDto(Item item) {
        super(item);
        this.score = item.getScore();
        this.voting = item.getVoting();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Voting getVoting() {
        return voting;
    }

    public void setVoting(Voting voting) {
        this.voting = voting;
    }
}
