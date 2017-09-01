package com.yalovchuk.web.controller._interface;

import com.yalovchuk.bean.Item;
import com.yalovchuk.bean.Topic;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.dto.TopicDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.web.controller._interface.base.CrudController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ItemController extends CrudController<Item, Long, ItemDto, ItemResource> {

    HttpStatus registerItem(Long itemId);
}
