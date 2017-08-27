package com.yalovchuk.service.proxy._interface;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.proxy._interface.base.CrudProxyService;

import java.util.List;

public interface VotingProxyService extends CrudProxyService<Voting, Long, VotingDto, VotingResource> {

    VotingResource createByTopicId(VotingDto votingDto, Long topicId);

    VotingResource readByTopicIdAndId(Long topicId, Long votingId);

    VotingResource updateByTopicIdAndId(VotingDto votingDto, Long topicId, Long votingId);

    void deleteByTopicIdAndId(Long topicId, Long votingId);

    void deleteAllByTopicId(Long topicId);

    List<VotingResource> getAllByTopicId(Long topicId);
}
