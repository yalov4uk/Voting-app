package com.yalovchuk.service.main.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.TopicDao;
import com.yalovchuk.dao.VotingDao;
import com.yalovchuk.service.main._interface.VotingService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingServiceImpl extends CrudServiceImpl<Voting, Long> implements VotingService {

    @Autowired
    protected VotingDao votingDao;
    @Autowired
    protected TopicDao topicDao;

    protected CrudRepository<Voting, Long> getDao() {
        return votingDao;
    }

    @Override
    public Voting createByTopicId(Long topicId, Voting voting) {
        voting.setTopic(topicDao.findOne(topicId));
        return create(voting);
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
