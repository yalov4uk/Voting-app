package com.yalovchuk.service.complex.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.complex._interface.VotingComplexService;
import com.yalovchuk.service.main.implementation.VotingServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotingComplexServiceImpl extends VotingServiceImpl implements VotingComplexService {

    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public Voting dtoToBean(VotingDto beanDto) {
        Voting voting = modelMapper.map(beanDto, Voting.class);
        voting.setTopic(topicDao.findOne(beanDto.getTopicId()));
        return voting;
    }

    @Override
    public VotingResource beanToResource(Voting bean) {
        return modelMapper.map(bean, VotingResource.class);
    }

    @Override
    public VotingResource createResourceByTopicId(Long topicId, VotingDto votingDto) {
        Voting voting = dtoToBean(votingDto);
        voting = super.createByTopicId(topicId, voting);
        return beanToResource(voting);
    }

    @Override
    public void deleteAllResourcesByTopicId(Long topicId) {
        super.deleteAllByTopicId(topicId);
    }

    @Override
    public List<VotingResource> getAllResourcesByTopicId(Long topicId) {
        List<Voting> votings = super.getAllByTopicId(topicId);
        return votings.stream().map(this::beanToResource).collect(Collectors.toList());
    }
}
