package com.yalovchuk.service.main.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.bean.Topic;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.TopicDao;
import com.yalovchuk.dao.VotingDao;
import com.yalovchuk.service.exception.NotFoundException;
import com.yalovchuk.service.exception.NotValidException;
import com.yalovchuk.service.main._interface.VotingService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import com.yalovchuk.service.utils.validator._interface.VotingValidator;
import com.yalovchuk.service.utils.validator._interface.base.NamedBeanValidator;
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
        if (!votingValidator.validateEnable(bean)) throw new NotValidException();
        return super.create(bean);
    }

    @Override
    public Voting update(Long id, Voting newBean) {
        if (!votingValidator.validateEnable(newBean)) throw new NotValidException();
        return super.update(id, newBean);
    }

    @Override
    public Voting createByTopicId(Long topicId, Voting voting) {
        Topic topic = topicDao.findOne(topicId);
        if (topic == null) throw new NotFoundException();
        voting.setTopic(topic);
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
