package com.yalovchuk.web.controller._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.web.controller.base.mixin.DeleteController;
import com.yalovchuk.web.controller.base.mixin.ReadController;
import com.yalovchuk.web.controller.base.mixin.UpdateController;

public interface ItemController extends
        ReadController<Item, Long, ItemDto, ItemResource>,
        UpdateController<Item, Long, ItemDto, ItemResource>,
        DeleteController<Item, Long, ItemDto, ItemResource> {
}
