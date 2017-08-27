package com.yalovchuk.service.utils.validator.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.service.utils.validator._interface.ItemValidator;
import com.yalovchuk.service.utils.validator.implementation.base.NamedBeanValidatorImpl;
import org.springframework.stereotype.Service;

@Service
public class ItemValidatorImpl extends NamedBeanValidatorImpl<Item, Long> implements ItemValidator {

    @Override
    public boolean validateScore(Item item)  {
        Integer score = item.getScore();
        return score != null && score > 0;
    }
}
