package com.yalovchuk.web.controller.implementation;

import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.proxy._interface.VotingProxyService;
import com.yalovchuk.web.controller._interface.VotingController;
import com.yalovchuk.web.utility.link._interface.VotingLinkAssembly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "topics/{topicId}/votings/",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class VotingControllerImpl implements VotingController {

    @Autowired
    private VotingProxyService votingProxyService;
    @Autowired
    private VotingLinkAssembly votingLinkAssembly;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public HttpEntity<VotingResource> createVotingByTopicId(@RequestBody VotingDto votingDto,
                                                            @PathVariable Long topicId) {
        VotingResource votingResource = votingProxyService.createByTopicId(votingDto, topicId);
        addLinks(votingResource);
        return new ResponseEntity<>(votingResource, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{votingId}/", method = RequestMethod.GET)
    public HttpEntity<VotingResource> readVotingByTopicIdAndId(@PathVariable Long topicId,
                                                               @PathVariable Long votingId) {
        VotingResource votingResource = votingProxyService.readByTopicIdAndId(topicId, votingId);
        addLinks(votingResource);
        return new ResponseEntity<>(votingResource, HttpStatus.OK);
    }

    @RequestMapping(value = "/{votingId}/", method = RequestMethod.PUT)
    public HttpEntity<VotingResource> updateVotingByTopicIdAndId(@RequestBody VotingDto votingDto,
                                                                 @PathVariable Long topicId,
                                                                 @PathVariable Long votingId) {
        VotingResource votingResource = votingProxyService.updateByTopicIdAndId(votingDto, topicId, votingId);
        addLinks(votingResource);
        return new ResponseEntity<>(votingResource, HttpStatus.OK);
    }

    @RequestMapping(value = "/{votingId}/", method = RequestMethod.DELETE)
    public HttpStatus deleteAllItemsByTopicId(@PathVariable Long topicId, @PathVariable Long votingId) {
        votingProxyService.deleteByTopicIdAndId(topicId, votingId);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public HttpStatus deleteAllVotingsByTopicId(@PathVariable Long topicId) {
        votingProxyService.deleteAllByTopicId(topicId);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HttpEntity<List<VotingResource>> getAllVotingsByTopicId(@PathVariable Long topicId) {
        List<VotingResource> votingResources = votingProxyService.getAllByTopicId(topicId);
        votingResources.forEach(this::addLinks);
        return new ResponseEntity<>(votingResources, HttpStatus.OK);
    }

    @RequestMapping(value = "/{votingId}/", method = RequestMethod.POST)
    public HttpEntity<VotingResource> enableVoting(@PathVariable Long topicId, @PathVariable Long votingId,
                                                   @RequestParam Boolean enable) {
        VotingResource votingResource = votingProxyService.enableVoting(enable, topicId, votingId);
        addLinks(votingResource);
        return new ResponseEntity<>(votingResource, HttpStatus.OK);
    }

    private void addLinks(VotingResource resource) {
        votingLinkAssembly.addLinks(resource);
    }
}
