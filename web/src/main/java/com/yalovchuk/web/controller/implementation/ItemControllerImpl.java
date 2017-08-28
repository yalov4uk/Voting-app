package com.yalovchuk.web.controller.implementation;

import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.proxy._interface.ItemProxyService;
import com.yalovchuk.web.controller._interface.ItemController;
import com.yalovchuk.web.utility.link._interface.ItemLinkAssembly;
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
public class ItemControllerImpl implements ItemController {

    @Autowired
    private ItemProxyService itemProxyService;
    @Autowired
    private ItemLinkAssembly itemLinkAssembly;

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<ItemResource> createItemByTopicIdAndVotingId(@RequestBody ItemDto itemDto,
                                                                   @PathVariable Long topicId,
                                                                   @PathVariable Long votingId) {
        ItemResource itemResource = itemProxyService.createByTopicIdAndVotingId(itemDto, topicId, votingId);
        addLinks(itemResource);
        return new ResponseEntity<>(itemResource, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public HttpEntity<ItemResource> readItemByTopicIdAndVotingIdAndId(@PathVariable Long topicId,
                                                                      @PathVariable Long votingId,
                                                                      @PathVariable Long itemId) {
        ItemResource itemResource = itemProxyService.readByTopicIdAndVotingIdAndId(topicId, votingId, itemId);
        addLinks(itemResource);
        return new ResponseEntity<>(itemResource, HttpStatus.OK);
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.PUT)
    public HttpEntity<ItemResource> updateItemByTopicIdAndVotingIdAndId(@RequestBody ItemDto itemDto,
                                                                        @PathVariable Long topicId,
                                                                        @PathVariable Long votingId,
                                                                        @PathVariable Long itemId) {
        ItemResource itemResource = itemProxyService.updateByTopicIdAndVotingIdAndId(itemDto, topicId, votingId, itemId);
        addLinks(itemResource);
        return new ResponseEntity<>(itemResource, HttpStatus.OK);
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.DELETE)
    public HttpStatus deleteAllItemsByTopicIdAndVotingId(@PathVariable Long topicId, @PathVariable Long votingId,
                                                         @PathVariable Long itemId) {
        itemProxyService.deleteByTopicIdAndVotingIdAndId(topicId, votingId, itemId);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public HttpStatus deleteAllItemsByTopicIdAndVotingId(@PathVariable Long topicId, @PathVariable Long votingId) {
        itemProxyService.deleteAllByTopicIdAndVotingId(topicId, votingId);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<ItemResource>> getAllItemsByTopicIdAndVotingId(@PathVariable Long topicId,
                                                                          @PathVariable Long votingId) {
        List<ItemResource> itemResources = itemProxyService.getAllByTopicIdAndVotingId(topicId, votingId);
        itemResources.forEach(this::addLinks);
        return new ResponseEntity<>(itemResources, HttpStatus.OK);
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.POST)
    public HttpStatus registerItem(@PathVariable Long topicId, @PathVariable Long votingId, @PathVariable Long itemId) {
        itemProxyService.registerItem(topicId, votingId, itemId);
        return HttpStatus.OK;
    }

    private void addLinks(ItemResource resource) {
        itemLinkAssembly.addLinks(resource);
    }
}
