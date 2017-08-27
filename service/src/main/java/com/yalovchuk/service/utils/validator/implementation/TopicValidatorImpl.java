package com.yalovchuk.service.utils.validator.implementation;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dto.TopicDto;
import com.yalovchuk.service.utils.validator._interface.TopicValidator;
import com.yalovchuk.service.utils.validator.implementation.base.NamedBeanValidatorImpl;
import org.springframework.stereotype.Service;

@Service
public class TopicValidatorImpl extends NamedBeanValidatorImpl<Topic, Long>
        implements TopicValidator {
}
