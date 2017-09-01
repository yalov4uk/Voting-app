package com.yalovchuk.service.proxy._interface.nested;

import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;

import java.util.List;

public interface VotingProxyNestedService {

    VotingResource createByTopicId(VotingDto votingDto, Long topicId);

    void deleteAllByTopicId(Long topicId);

    List<VotingResource> getAllByTopicId(Long topicId);
}
