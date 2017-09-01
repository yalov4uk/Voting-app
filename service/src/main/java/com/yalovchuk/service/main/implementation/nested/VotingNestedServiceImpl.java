package com.yalovchuk.service.main.implementation.nested;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.VotingDao;
import com.yalovchuk.service.main._interface.TopicService;
import com.yalovchuk.service.main._interface.VotingService;
import com.yalovchuk.service.main._interface.nested.VotingNestedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingNestedServiceImpl implements VotingNestedService {

    @Autowired
    private VotingDao votingDao;
    @Autowired
    private VotingService votingService;
    @Autowired
    private TopicService topicService;

    @Override
    public Voting createByTopicId(Voting voting, Long topicId) {
        Topic topic = topicService.read(topicId);
        voting.setTopic(topic);
        return votingService.create(voting);
    }

    @Override
    public void deleteAllByTopicId(Long topicId) {
        votingDao.deleteAllByTopicId(topicId);
    }


    @Override
    public List<Voting> getAllByTopicId(Long topicId) {
        return votingDao.getAllByTopicId(topicId);
    }

}
