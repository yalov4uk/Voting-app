package com.yalovchuk.service.proxy._interface;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.proxy._interface.base.CrudProxyService;

public interface VotingProxyService extends CrudProxyService<Voting, Long, VotingDto, VotingResource> {

    VotingResource enableVoting(Boolean enable, Long votingId);
}
