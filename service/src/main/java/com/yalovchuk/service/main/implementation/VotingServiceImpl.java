package com.yalovchuk.service.main.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.VotingDao;
import com.yalovchuk.service.exception.NotValidException;
import com.yalovchuk.service.main._interface.VotingService;
import com.yalovchuk.service.main.implementation.base.CrudServiceImpl;
import com.yalovchuk.service.utility.validator._interface.VotingValidator;
import com.yalovchuk.service.utility.validator._interface.base.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class VotingServiceImpl extends CrudServiceImpl<Voting, Long> implements VotingService {

    @Autowired
    private VotingDao votingDao;
    @Autowired
    private VotingValidator votingValidator;

    protected CrudRepository<Voting, Long> getDao() {
        return votingDao;
    }

    @Override
    protected void loadLists(Voting oldVoting, Voting newVoting) {
        newVoting.setItems(oldVoting.getItems());
    }

    @Override
    protected BeanValidator<Voting, Long> getValidator() {
        return votingValidator;
    }

    @Override
    public Voting create(Voting voting) {
        if (!votingValidator.validateName(voting) || !votingValidator.validateTopic(voting))
            throw new NotValidException();
        voting.setEnable(false);
        return super.create(voting);
    }

    @Override
    public Voting update(Voting newVoting, Long id) {
        if (!votingValidator.validateName(newVoting) || !votingValidator.validateTopic(newVoting))
            throw new NotValidException();
        newVoting.setEnable(false);
        return super.update(newVoting, id);
    }

    @Override
    public Voting enableVoting(Boolean enable, Long votingId) {
        if (Objects.isNull(enable)) throw new NotValidException();
        Voting voting = super.read(votingId);
        voting.setEnable(enable);
        return voting;
    }
}
