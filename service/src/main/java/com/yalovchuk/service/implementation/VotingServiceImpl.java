package com.yalovchuk.service.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.VotingDao;
import com.yalovchuk.service._interface.VotingService;
import com.yalovchuk.service.implementation.base.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class VotingServiceImpl extends CrudServiceImpl<Voting, Long> implements VotingService {

    @Autowired
    private VotingDao votingDao;

    @Override
    protected CrudRepository<Voting, Long> getDao() {
        return votingDao;
    }
}
