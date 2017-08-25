package com.yalovchuk.service.crud.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.VotingDao;
import com.yalovchuk.service.crud._interface.VotingService;
import com.yalovchuk.service.crud.implementation.base.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class VotingServiceImpl extends CrudServiceImpl<Voting, Long> implements VotingService {

    @Autowired
    protected VotingDao votingDao;

    protected CrudRepository<Voting, Long> getDao() {
        return votingDao;
    }
}
