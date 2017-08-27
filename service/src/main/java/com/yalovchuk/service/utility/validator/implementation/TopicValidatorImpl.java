package com.yalovchuk.service.utility.validator.implementation;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.service.utility.validator._interface.TopicValidator;
import com.yalovchuk.service.utility.validator.implementation.base.NamedBeanValidatorImpl;
import org.springframework.stereotype.Service;

@Service
public class TopicValidatorImpl extends NamedBeanValidatorImpl<Topic, Long> implements TopicValidator {
}
