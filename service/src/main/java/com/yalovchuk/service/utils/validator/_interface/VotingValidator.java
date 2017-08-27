package com.yalovchuk.service.utils.validator._interface;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.service.utils.validator._interface.base.NamedBeanValidator;

public interface VotingValidator extends NamedBeanValidator<Voting, Long> {

    boolean validateEnable(Voting voting);
}
