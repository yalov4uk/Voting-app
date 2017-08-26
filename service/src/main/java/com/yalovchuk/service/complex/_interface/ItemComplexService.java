package com.yalovchuk.service.complex._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.complex._interface.base.CrudComplexService;

public interface ItemComplexService extends CrudComplexService<Item, Long, ItemDto, ItemResource> {
}
