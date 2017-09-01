package com.yalovchuk.service.main._interface.nested;

import com.yalovchuk.bean.Voting;

import java.util.List;

public interface VotingNestedService {

    Voting createByTopicId(Voting voting, Long topicId);

    void deleteAllByTopicId(Long topicId);

    List<Voting> getAllByTopicId(Long topicId);
}
