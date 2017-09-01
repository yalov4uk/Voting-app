package com.yalovchuk.dao;

import com.yalovchuk.bean.Voting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VotingDao extends CrudRepository<Voting, Long> {

    Voting readByTopicIdAndId(Long topicId, Long votingId);

    void deleteAllByTopicId(Long topicId);

    List<Voting> getAllByTopicId(Long topicId);
}
