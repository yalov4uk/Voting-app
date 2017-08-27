package com.yalovchuk.service.utils.validator.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.service.utils.validator._interface.VotingValidator;
import com.yalovchuk.service.utils.validator.implementation.base.NamedBeanValidatorImpl;
import org.springframework.stereotype.Service;

@Service
public class VotingValidatorImpl extends NamedBeanValidatorImpl<Voting, Long> implements VotingValidator {

    @Override
    public boolean validateEnable(Voting voting) {
        Boolean enable = voting.getEnable();
        return enable != null && !enable;
    }
}
