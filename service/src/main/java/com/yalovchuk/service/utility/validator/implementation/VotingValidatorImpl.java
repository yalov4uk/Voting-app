package com.yalovchuk.service.utility.validator.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.service.utility.validator._interface.VotingValidator;
import com.yalovchuk.service.utility.validator.implementation.base.NamedBeanValidatorImpl;
import org.springframework.stereotype.Service;

@Service
public class VotingValidatorImpl extends NamedBeanValidatorImpl<Voting, Long> implements VotingValidator {

    @Override
    public boolean validateTopic(Voting voting) {
        return voting.getTopic() != null;
    }
}
