package com.yalovchuk.service.utility.mapper.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dao.TopicDao;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.utility.mapper._interface.TopicMapper;
import com.yalovchuk.service.utility.mapper._interface.VotingMapper;
import com.yalovchuk.service.utility.mapper.implementation.base.MapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotingMapperImpl extends MapperImpl<Voting, Long, VotingDto, VotingResource> implements VotingMapper {

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private TopicDao topicDao;

    @Override
    protected Class<Voting> getBeanClass() {
        return Voting.class;
    }

    @Override
    protected Class<VotingResource> getResourceClass() {
        return VotingResource.class;
    }

    @Override
    public Voting dtoToBean(VotingDto beanDto) {
        Voting voting = super.dtoToBean(beanDto);
        if (beanDto.getTopicId() != null) voting.setTopic(topicDao.findOne(beanDto.getTopicId()));
        return voting;
    }

    @Override
    public VotingResource beanToResource(Voting bean) {
        VotingResource votingResource = super.beanToResource(bean);
        votingResource.setTopic(topicMapper.beanToResource(bean.getTopic()));
        return votingResource;
    }
}
