package com.yalovchuk.service.utils.mapper._interface;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.utils.mapper._interface.base.Mapper;

public interface VotingMapper extends Mapper<Voting, Long, VotingDto, VotingResource> {
}
