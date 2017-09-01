package com.yalovchuk.service.proxy.implementation.nested;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.main._interface.nested.VotingNestedService;
import com.yalovchuk.service.proxy._interface.nested.VotingProxyNestedService;
import com.yalovchuk.service.utility.mapper._interface.VotingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotingProxyNestedServiceImpl implements VotingProxyNestedService {

    @Autowired
    private VotingNestedService votingNestedService;
    @Autowired
    private VotingMapper votingMapper;

    @Override
    public VotingResource createByTopicId(VotingDto votingDto, Long topicId) {
        votingDto.setTopicId(null);
        Voting voting = votingMapper.dtoToBean(votingDto);
        voting = votingNestedService.createByTopicId(voting, topicId);
        return votingMapper.beanToResource(voting);
    }

    @Override
    public void deleteAllByTopicId(Long topicId) {
        votingNestedService.deleteAllByTopicId(topicId);
    }

    @Override
    public List<VotingResource> getAllByTopicId(Long topicId) {
        List<Voting> votings = votingNestedService.getAllByTopicId(topicId);
        return votings.stream().map(votingMapper::beanToResource).collect(Collectors.toList());
    }
}
