package com.yalovchuk.service.proxy._interface;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.proxy._interface.base.CrudProxyService;

import java.util.List;

public interface VotingProxyService extends CrudProxyService<Voting, Long, VotingDto, VotingResource> {

    VotingResource createResourceByTopicId(Long topicId, VotingDto votingDto);

    void deleteAllResourcesByTopicId(Long topicId);

    List<VotingResource> getAllResourcesByTopicId(Long topicId);
}
