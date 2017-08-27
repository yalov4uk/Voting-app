package com.yalovchuk.web.controller._interface;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.web.controller.base.mixin.DeleteController;
import com.yalovchuk.web.controller.base.mixin.ReadController;
import com.yalovchuk.web.controller.base.mixin.UpdateController;

public interface VotingController extends
        ReadController<Voting, Long, VotingDto, VotingResource>,
        UpdateController<Voting, Long, VotingDto, VotingResource>,
        DeleteController<Voting, Long, VotingDto, VotingResource> {
}
