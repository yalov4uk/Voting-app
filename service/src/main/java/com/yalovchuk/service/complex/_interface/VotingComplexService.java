package com.yalovchuk.service.complex._interface;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.complex._interface.mixin.CrudComplexService;

import java.util.List;

public interface VotingComplexService extends CrudComplexService<Voting, Long, VotingDto, VotingResource> {

    VotingResource createResourceByTopicId(Long topicId, VotingDto votingDto);

    void deleteAllResourcesByTopicId(Long topicId);

    List<VotingResource> getAllResourcesByTopicId(Long topicId);
}
