package com.yalovchuk.bean;

import com.yalovchuk.bean.base.NamedBean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item")
public class Item extends NamedBean<Long> {

    @Column(name = "score", nullable = false)
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "voting_id", nullable = false)
    private Voting voting;

    public Item() {
        super();
    }

    public Item(String name, Integer score, Voting voting) {
        super(name);
        this.score = score;
        this.voting = voting;
    }

    public synchronized void incScore() {
        score++;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        if (!super.equals(o)) return false;
        Item item = (Item) o;
        return Objects.equals(score, item.score) &&
                Objects.equals(voting, item.voting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), score, voting);
    }

    @Override
    public String toString() {
        return "Item{" +
                super.toString() +
                ", score=" + score +
                ", voting=" + voting +
                '}';
    }
}
