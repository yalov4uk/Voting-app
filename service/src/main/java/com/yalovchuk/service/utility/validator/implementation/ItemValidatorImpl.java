package com.yalovchuk.service.utility.validator.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.service.utility.validator._interface.ItemValidator;
import com.yalovchuk.service.utility.validator.implementation.base.NamedBeanValidatorImpl;
import org.springframework.stereotype.Service;

@Service
public class ItemValidatorImpl extends NamedBeanValidatorImpl<Item, Long> implements ItemValidator {
}
