package com.yalovchuk.web.controller.implementation;

import com.yalovchuk.bean.Item;
import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.proxy._interface.ItemProxyService;
import com.yalovchuk.service.proxy._interface.base.CrudProxyService;
import com.yalovchuk.web.controller._interface.ItemController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "topics/{topicId}/votings/{votingId}/items",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class ItemControllerImpl implements ItemController {

    @Autowired
    private ItemProxyService itemProxyService;

    @Override
    public CrudProxyService<Item, Long, ItemDto, ItemResource> getService() {
        return itemProxyService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public HttpEntity<ItemResource> createItemByVotingId(@PathVariable Long votingId, @RequestBody ItemDto itemDto) {
        return new ResponseEntity<>(itemProxyService.createByVotingId(votingId, itemDto), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public HttpStatus deleteAllItemsByVotingId(@PathVariable Long votingId) {
        itemProxyService.deleteAllByVotingId(votingId);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HttpEntity<List<ItemResource>> getAllItemsByVotingId(@PathVariable Long votingId) {
        return new ResponseEntity<>(itemProxyService.getAllByVotingId(votingId), HttpStatus.OK);
    }
}
