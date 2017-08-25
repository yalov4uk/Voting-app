package com.yalovchuk.service.complex.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.service.complex._interface.VotingComplexService;
import com.yalovchuk.service.crud._interface.TopicService;
import com.yalovchuk.service.crud.implementation.VotingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingComplexServiceImpl extends VotingServiceImpl implements VotingComplexService {

    @Autowired
    private TopicService topicService;

    @Override
    public Voting create(Long topicId, Voting voting) {
        voting.setTopic(topicService.read(topicId));
        return super.create(voting);
    }

    @Override
    public List<Voting> getAll(Long topicId) {
        return votingDao.getAllByTopicId(topicId);
    }
}
