package com.yalovchuk.web.controller._interface;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.TopicDto;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.web.controller._interface.base.CrudController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface VotingController extends CrudController<Voting, Long, VotingDto, VotingResource> {

    HttpEntity<VotingResource> enableVoting(Boolean enable, Long votingId);
}
