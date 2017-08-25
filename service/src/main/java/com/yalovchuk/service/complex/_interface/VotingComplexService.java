package com.yalovchuk.service.complex._interface;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.service.crud._interface.VotingService;

import java.util.List;

public interface VotingComplexService extends VotingService {

    Voting create(Long topicId, Voting voting);

    List<Voting> getAll(Long topicId);
}
