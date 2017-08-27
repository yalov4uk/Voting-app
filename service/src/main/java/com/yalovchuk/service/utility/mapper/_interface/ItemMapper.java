package com.yalovchuk.service.utility.mapper._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.utility.mapper._interface.base.Mapper;

public interface ItemMapper extends Mapper<Item, Long, ItemDto, ItemResource> {
}
