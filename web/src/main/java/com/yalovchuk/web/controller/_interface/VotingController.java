package com.yalovchuk.web.controller._interface;

import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface VotingController {

    HttpEntity<VotingResource> createVotingByTopicId(VotingDto votingDto, Long topicId);

    HttpEntity<VotingResource> readVotingByTopicIdAndId(Long topicId, Long votingId);

    HttpEntity<VotingResource> updateVotingByTopicIdAndId(VotingDto votingDto, Long topicId, Long votingId);

    HttpStatus deleteAllItemsByTopicId(Long topicId, Long votingId);

    HttpStatus deleteAllVotingsByTopicId(Long topicId);

    HttpEntity<List<VotingResource>> getAllVotingsByTopicId(Long topicId);
}
