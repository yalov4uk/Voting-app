package com.yalov4uk.bean;

import com.yalov4uk.bean.base.Bean;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "topic")
public class Topic extends Bean {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topic",fetch = FetchType.LAZY)
    private Set<Voting> votings;

    public Topic() {
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
