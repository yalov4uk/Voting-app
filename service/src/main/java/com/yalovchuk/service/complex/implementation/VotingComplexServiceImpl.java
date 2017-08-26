package com.yalovchuk.service.complex.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.VotingDao;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.complex._interface.VotingComplexService;
import com.yalovchuk.service.main.implementation.VotingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotingComplexServiceImpl extends VotingServiceImpl implements VotingComplexService {

    @Override
    public Voting dtoToBean(VotingDto beanDto) {
        return null;
    }

    @Override
    public VotingResource beanToResource(Voting bean) {
        return null;
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
