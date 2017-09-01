package com.yalovchuk.web.controller.implementation.nested;

import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.proxy._interface.nested.VotingProxyNestedService;
import com.yalovchuk.web.controller._interface.nested.VotingNestedController;
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
        value = "api/v1/topics/{topicId}/votings",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class VotingNestedControllerImpl implements VotingNestedController {

    @Autowired
    private VotingProxyNestedService votingProxyNestedService;
    @Autowired
    private VotingLinkAssembly votingLinkAssembly;

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<VotingResource> createVotingByTopicId(@RequestBody VotingDto votingDto,
                                                            @PathVariable Long topicId) {
        VotingResource votingResource = votingProxyNestedService.createByTopicId(votingDto, topicId);
        votingLinkAssembly.addLinks(votingResource);
        return new ResponseEntity<>(votingResource, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public HttpStatus deleteAllVotingsByTopicId(@PathVariable Long topicId) {
        votingProxyNestedService.deleteAllByTopicId(topicId);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<VotingResource>> getAllVotingsByTopicId(@PathVariable Long topicId) {
        List<VotingResource> votingResources = votingProxyNestedService.getAllByTopicId(topicId);
        votingResources.forEach(votingLinkAssembly::addLinks);
        return new ResponseEntity<>(votingResources, HttpStatus.OK);
    }
}
