package com.yalovchuk.bean;

import com.yalovchuk.bean.base.NamedBean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "voting")
public class Voting extends NamedBean<Long> {

    @Column(name = "enable", nullable = false)
    private Boolean enable;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voting", fetch = FetchType.LAZY)
    private Set<Item> items = new HashSet<>();

    protected Voting() {
        super();
    }

    public Voting(String name, Boolean enable) {
        super(name);
        this.enable = enable;
    }

    public Voting(String name, Boolean enable, Topic topic) {
        super(name);
        this.enable = enable;
        this.topic = topic;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voting)) return false;
        if (!super.equals(o)) return false;
        Voting voting = (Voting) o;
        return Objects.equals(enable, voting.enable) &&
                Objects.equals(topic, voting.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), enable, topic);
    }

    @Override
    public String toString() {
        return "Voting{" +
                super.toString() +
                ", enable=" + enable +
                ", topic=" + topic +
                '}';
    }
}
