package com.yalovchuk.web.controller._interface.nested;

import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface VotingNestedController {

    HttpEntity<VotingResource> createVotingByTopicId(VotingDto votingDto, Long topicId);

    HttpStatus deleteAllVotingsByTopicId(Long topicId);

    HttpEntity<List<VotingResource>> getAllVotingsByTopicId(Long topicId);
}
