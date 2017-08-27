package com.yalovchuk.service.main.implementation;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.VotingDao;
import com.yalovchuk.service.exception.NotFoundException;
import com.yalovchuk.service.exception.NotValidException;
import com.yalovchuk.service.main._interface.TopicService;
import com.yalovchuk.service.main._interface.VotingService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import com.yalovchuk.service.utility.validator._interface.VotingValidator;
import com.yalovchuk.service.utility.validator._interface.base.NamedBeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VotingServiceImpl extends CrudServiceImpl<Voting, Long> implements VotingService {

    @Autowired
    protected VotingDao votingDao;
    @Autowired
    protected TopicService topicService;
    @Autowired
    protected VotingValidator votingValidator;

    protected CrudRepository<Voting, Long> getDao() {
        return votingDao;
    }

    @Override
    protected void loadLists(Voting oldBean, Voting newBean) {
        newBean.setItems(oldBean.getItems());
    }

    @Override
    protected NamedBeanValidator<Voting, Long> getValidator() {
        return votingValidator;
    }

    @Override
    public Voting create(Voting bean) {
        bean.setEnable(false);
        return super.create(bean);
    }

    @Override
    public Voting read(Long id) {
        Voting voting = votingDao.findByIdAndEnableTrue(id);
        if (voting == null) throw new NotFoundException();
        return voting;
    }

    @Override
    public Voting update(Voting newBean, Long id) {
        newBean.setEnable(false);
        return super.update(newBean, id);
    }

    @Override
    public Voting createByTopicId(Voting voting, Long topicId) {
        Topic topic = topicService.read(topicId);
        voting.setTopic(topic);
        return create(voting);
    }

    @Override
    public Voting readByTopicIdAndId(Long topicId, Long votingId) {
        Voting voting = read(votingId);
        if (voting.getTopic() == null || !Objects.equals(voting.getTopic().getId(), topicId))
            throw new NotFoundException();
        return voting;
    }

    @Override
    public Voting updateByTopicIdAndId(Voting newVoting, Long topicId, Long votingId) {
        readByTopicIdAndId(topicId, votingId);
        return update(newVoting, votingId);
    }

    @Override
    public void deleteByTopicIdAndId(Long topicId, Long votingId) {
        votingDao.deleteByTopicIdAndId(topicId, votingId);
    }

    @Override
    public void deleteAllByTopicId(Long topicId) {
        votingDao.deleteAllByTopicId(topicId);
    }


    @Override
    public List<Voting> getAllByTopicId(Long topicId) {
        return votingDao.getAllByTopicIdAndEnableTrue(topicId);
    }

    @Override
    public Voting enableVoting(Boolean enable, Long topicId, Long votingId) {
        if (enable == null) throw new NotValidException();
        Voting voting = super.read(votingId);
        if (voting.getTopic() == null || !Objects.equals(voting.getTopic().getId(), topicId))
            throw new NotFoundException();
        voting.setEnable(enable);
        return voting;
    }
}
