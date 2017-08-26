package com.yalovchuk.dto;

import com.yalovchuk.bean.Item;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.base.NamedBeanDto;

public class ItemDto extends NamedBeanDto<Item, Long> {

    private Integer score;
    private VotingDto voting;

    public ItemDto(Long id, String name, Integer score, VotingDto voting) {
        super(id, name);
        this.score = score;
        this.voting = voting;
    }

    public ItemDto(Item item, VotingDto voting) {
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

    public VotingDto getVoting() {
        return voting;
    }

    public void setVoting(VotingDto voting) {
        this.voting = voting;
    }
}
