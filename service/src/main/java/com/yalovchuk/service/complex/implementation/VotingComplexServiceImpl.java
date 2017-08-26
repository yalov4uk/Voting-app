package com.yalovchuk.service.complex.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.VotingDao;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.complex._interface.VotingComplexService;
import com.yalovchuk.service.complex.implementation.base.CrudComplexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class VotingComplexServiceImpl extends CrudComplexServiceImpl<Voting, Long, VotingDto, VotingResource> implements
        VotingComplexService {

    @Autowired
    protected VotingDao votingDao;

    @Override
    protected Class<Voting> getBeanClass() {
        return Voting.class;
    }

    @Override
    protected Class<VotingDto> getDtoClass() {
        return VotingDto.class;
    }

    @Override
    protected Class<VotingResource> getResourceClass() {
        return VotingResource.class;
    }

    @Override
    protected CrudRepository<Voting, Long> getDao() {
        return votingDao;
    }
}
