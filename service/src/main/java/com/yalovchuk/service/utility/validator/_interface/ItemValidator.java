package com.yalovchuk.service.utility.validator._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.service.utility.validator._interface.base.NamedBeanValidator;

public interface ItemValidator extends NamedBeanValidator<Item, Long> {

    boolean validateVoting(Item item);
}
