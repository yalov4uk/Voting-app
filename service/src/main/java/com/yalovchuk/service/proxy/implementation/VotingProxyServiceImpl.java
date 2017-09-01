package com.yalovchuk.service.proxy.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.main._interface.VotingService;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.service.proxy._interface.VotingProxyService;
import com.yalovchuk.service.proxy.implementation.base.CrudProxyServiceImpl;
import com.yalovchuk.service.utility.mapper._interface.VotingMapper;
import com.yalovchuk.service.utility.mapper._interface.base.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class VotingProxyServiceImpl extends CrudProxyServiceImpl<Voting, Long, VotingDto, VotingResource>
        implements VotingProxyService {

    @Autowired
    private VotingService votingService;
    @Autowired
    private VotingMapper votingMapper;

    @Override
    protected CrudService<Voting, Long> getService() {
        return votingService;
    }

    @Override
    public Mapper<Voting, Long, VotingDto, VotingResource> getMapper() {
        return votingMapper;
    }

    @Override
    public VotingResource enableVoting(Boolean enable, Long votingId) {
        Voting voting = votingService.enableVoting(enable, votingId);
        return votingMapper.beanToResource(voting);
    }
}
