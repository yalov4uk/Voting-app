package com.yalovchuk.web.controller._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.web.controller._interface.base.CrudController;
import org.springframework.http.HttpStatus;

public interface ItemController extends CrudController<Item, Long, ItemDto, ItemResource> {

    HttpStatus registerItem(Long itemId);
}
