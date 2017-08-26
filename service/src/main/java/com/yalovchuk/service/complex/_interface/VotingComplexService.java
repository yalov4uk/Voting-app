package com.yalovchuk.service.complex._interface;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.complex._interface.base.CrudComplexService;

public interface VotingComplexService extends CrudComplexService<Voting, Long, VotingDto, VotingResource> {
}
