package com.yalovchuk.service.complex.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.complex._interface.VotingComplexService;
import com.yalovchuk.service.main.implementation.VotingServiceImpl;
import com.yalovchuk.service.utils.mapper._interface.VotingMapper;
import com.yalovchuk.service.utils.mapper._interface.base.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotingComplexServiceImpl extends VotingServiceImpl implements VotingComplexService {

    @Autowired
    protected VotingMapper votingMapper;

    @Override
    public Mapper<Voting, Long, VotingDto, VotingResource> getMapper() {
        return votingMapper;
    }

    @Override
    public VotingResource createResourceByTopicId(Long topicId, VotingDto votingDto) {
        Voting voting = votingMapper.dtoToBean(votingDto);
        voting = super.createByTopicId(topicId, voting);
        return votingMapper.beanToResource(voting);
    }

    @Override
    public void deleteAllResourcesByTopicId(Long topicId) {
        super.deleteAllByTopicId(topicId);
    }

    @Override
    public List<VotingResource> getAllResourcesByTopicId(Long topicId) {
        List<Voting> votings = super.getAllByTopicId(topicId);
        return votings.stream().map(this.votingMapper::beanToResource).collect(Collectors.toList());
    }
}
