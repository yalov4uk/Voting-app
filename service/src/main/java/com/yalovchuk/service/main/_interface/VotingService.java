package com.yalovchuk.service.main._interface;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.service.main._interface.base.CrudService;

import java.util.List;

public interface VotingService extends CrudService<Voting, Long> {

    Voting createByTopicId(Long topicId, Voting voting);

    void deleteAllByTopicId(Long topicId);

    List<Voting> getAllByTopicId(Long topicId);
}
