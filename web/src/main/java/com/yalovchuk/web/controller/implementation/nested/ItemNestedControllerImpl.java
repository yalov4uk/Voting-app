package com.yalovchuk.web.controller.implementation.nested;

import com.yalovchuk.dto.ItemDto;
import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.service.proxy._interface.ItemProxyService;
import com.yalovchuk.web.controller._interface.nested.ItemNestedController;
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
public class ItemNestedControllerImpl implements ItemNestedController {

    @Autowired
    private ItemProxyService itemProxyService;
    @Autowired
    private ItemLinkAssembly itemLinkAssembly;

    @RequestMapping(value = "/topics/{topicId}/votings/{votingId}/items", method = RequestMethod.POST)
    public HttpEntity<ItemResource> createItemByTopicIdAndVotingId(@RequestBody ItemDto itemDto,
                                                                   @PathVariable Long topicId,
                                                                   @PathVariable Long votingId) {
        ItemResource itemResource = itemProxyService.createByTopicIdAndVotingId(itemDto, topicId, votingId);
        itemLinkAssembly.addLinks(itemResource);
        return new ResponseEntity<>(itemResource, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/topics/{topicId}/votings/{votingId}/items", method = RequestMethod.DELETE)
    public HttpStatus deleteAllItemsByTopicIdAndVotingId(@PathVariable Long topicId, @PathVariable Long votingId) {
        itemProxyService.deleteAllByTopicIdAndVotingId(topicId, votingId);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/topics/{topicId}/votings/{votingId}/items", method = RequestMethod.GET)
    public HttpEntity<List<ItemResource>> getAllItemsByTopicIdAndVotingId(@PathVariable Long topicId,
                                                                          @PathVariable Long votingId) {
        List<ItemResource> itemResources = itemProxyService.getAllByTopicIdAndVotingId(topicId, votingId);
        itemResources.forEach(itemLinkAssembly::addLinks);
        return new ResponseEntity<>(itemResources, HttpStatus.OK);
    }
}
