package com.yalovchuk.web.controller.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.proxy._interface.ItemProxyService;
import com.yalovchuk.service.proxy._interface.base.CrudProxyService;
import com.yalovchuk.web.controller._interface.ItemController;
import com.yalovchuk.web.controller._interface.base.CrudController;
import com.yalovchuk.web.controller.implementation.base.CrudControllerImpl;
import com.yalovchuk.web.utility.link._interface.ItemLinkAssembly;
import com.yalovchuk.web.utility.link._interface.base.LinkAssembly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "api/v1/topics/{topicId}/votings/{votingId}/items",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class ItemControllerImpl extends CrudControllerImpl<Item, Long, ItemDto, ItemResource>
        implements ItemController {

    @Autowired
    private ItemProxyService itemProxyService;
    @Autowired
    private ItemLinkAssembly itemLinkAssembly;

    @Override
    protected CrudProxyService<Item, Long, ItemDto, ItemResource> getService() {
        return itemProxyService;
    }

    @Override
    protected LinkAssembly<Item, Long, ItemResource> getLinkAssembly() {
        return itemLinkAssembly;
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.POST)
    public HttpStatus registerItem(@PathVariable Long itemId) {
        itemProxyService.registerItem(itemId);
        return HttpStatus.OK;
    }
}
