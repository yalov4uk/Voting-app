package com.yalovchuk.service.main._interface;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.service.main._interface.base.CrudService;

public interface VotingService extends CrudService<Voting, Long> {

    Voting enableVoting(Boolean Enable, Long votingId);
}
