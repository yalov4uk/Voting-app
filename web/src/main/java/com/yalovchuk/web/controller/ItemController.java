package com.yalovchuk.web.controller;

import com.yalovchuk.bean.Item;
import com.yalovchuk.service.main._interface.ItemService;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.web.controller.base.mixin.DeleteController;
import com.yalovchuk.web.controller.base.mixin.ReadController;
import com.yalovchuk.web.controller.base.mixin.UpdateController;
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
public class ItemController implements
        ReadController<Item, Long>,
        UpdateController<Item, Long>,
        DeleteController<Item, Long> {

    @Autowired
    private ItemService itemService;

    @Override
    public CrudService<Item, Long> getService() {
        return itemService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public HttpEntity<Item> createVotingByTopicId(@PathVariable Long votingId, @RequestBody Item item) {
        return new ResponseEntity<>(itemService.createByVotingId(votingId, item), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public HttpStatus deleteAllVotingsByTopicId(@PathVariable Long votingId) {
        itemService.deleteAllByVotingId(votingId);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HttpEntity<List<Item>> getAllVotingsByTopicId(@PathVariable Long votingId) {
        return new ResponseEntity<>(itemService.getAllByVotingId(votingId), HttpStatus.OK);
    }
}
