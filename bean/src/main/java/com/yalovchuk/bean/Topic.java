package com.yalovchuk.bean;

import com.yalovchuk.bean.base.NamedBean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "topic")
public class Topic extends NamedBean<Long> {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topic", fetch = FetchType.LAZY)
    private Set<Voting> votings = new HashSet<>();

    protected Topic() {
        super();
    }

    public Topic(String name) {
        super(name);
    }

    public Set<Voting> getVotings() {
        return votings;
    }

    public void setVotings(Set<Voting> votings) {
        this.votings = votings;
    }

    @Override
    public String toString() {
        return "Topic{" +
                super.toString() +
                "}";
    }
}
