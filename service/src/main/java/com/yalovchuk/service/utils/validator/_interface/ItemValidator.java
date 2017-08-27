package com.yalovchuk.service.utils.validator._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.service.utils.validator._interface.base.NamedBeanValidator;

public interface ItemValidator extends NamedBeanValidator<Item, Long> {

    boolean validateScore(Item item);
}
