package com.yalovchuk.service.proxy.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.main._interface.VotingService;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.service.proxy._interface.VotingProxyService;
import com.yalovchuk.service.proxy.implementation.base.CrudProxyService;
import com.yalovchuk.service.utility.mapper._interface.VotingMapper;
import com.yalovchuk.service.utility.mapper._interface.base.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotingProxyServiceImpl extends CrudProxyService<Voting, Long, VotingDto, VotingResource>
        implements VotingProxyService {

    @Autowired
    protected VotingMapper votingMapper;
    @Autowired
    private VotingService votingService;

    @Override
    protected CrudService<Voting, Long> getService() {
        return votingService;
    }

    @Override
    public Mapper<Voting, Long, VotingDto, VotingResource> getMapper() {
        return votingMapper;
    }

    @Override
    public VotingResource createByTopicId(VotingDto votingDto, Long topicId) {
        Voting voting = votingMapper.dtoToBean(votingDto);
        voting = votingService.createByTopicId(voting, topicId);
        return votingMapper.beanToResource(voting);
    }

    @Override
    public VotingResource readByTopicIdAndId(Long topicId, Long votingId) {
        Voting voting = votingService.readByTopicIdAndId(topicId, votingId);
        return votingMapper.beanToResource(voting);
    }

    @Override
    public VotingResource updateByTopicIdAndId(VotingDto votingDto, Long topicId, Long votingId) {
        Voting voting = votingMapper.dtoToBean(votingDto);
        voting = votingService.updateByTopicIdAndId(voting, topicId, votingId);
        return votingMapper.beanToResource(voting);
    }

    @Override
    public void deleteByTopicIdAndId(Long topicId, Long votingId) {
        votingService.deleteByTopicIdAndId(topicId, votingId);
    }

    @Override
    public void deleteAllByTopicId(Long topicId) {
        votingService.deleteAllByTopicId(topicId);
    }

    @Override
    public List<VotingResource> getAllByTopicId(Long topicId) {
        List<Voting> votings = votingService.getAllByTopicId(topicId);
        return votings.stream().map(this.votingMapper::beanToResource).collect(Collectors.toList());
    }
}
