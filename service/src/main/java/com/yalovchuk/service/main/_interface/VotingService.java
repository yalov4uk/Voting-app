package com.yalovchuk.service.main._interface;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.service.main._interface.base.CrudService;

import java.util.List;

public interface VotingService extends CrudService<Voting, Long> {

    Voting createByTopicId(Voting voting, Long topicId);

    Voting readByTopicIdAndId(Long topicId, Long votingId);

    Voting updateByTopicIdAndId(Voting voting, Long topicId, Long votingId);

    void deleteByTopicIdAndId(Long topicId, Long votingId);

    void deleteAllByTopicId(Long topicId);

    List<Voting> getAllByTopicId(Long topicId);

    Voting enableVoting(Boolean Enable, Long topicId, Long votingId);
}
