package com.yalovchuk.dto;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.base.NamedBeanDto;

public class ItemDto extends NamedBeanDto<Item, Long> {

    private Integer score;
    private Long votingId;

    public ItemDto(Long id, String name, Integer score, Long votingId) {
        super(id, name);
        this.score = score;
        this.votingId = votingId;
    }

    public ItemDto(Item item) {
        super(item);
        this.score = item.getScore();
        this.votingId = item.getVoting().getId();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getVotingId() {
        return votingId;
    }

    public void setVotingId(Long votingId) {
        this.votingId = votingId;
    }
}
