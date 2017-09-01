package com.yalovchuk.web.controller.implementation.nested;

import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.proxy._interface.VotingProxyService;
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
    private VotingProxyService votingProxyService;
    @Autowired
    private VotingLinkAssembly votingLinkAssembly;

    @RequestMapping(value = "/topics/{topicId}/votings", method = RequestMethod.POST)
    public HttpEntity<VotingResource> createVotingByTopicId(@RequestBody VotingDto votingDto,
                                                            @PathVariable Long topicId) {
        VotingResource votingResource = votingProxyService.createByTopicId(votingDto, topicId);
        votingLinkAssembly.addLinks(votingResource);
        return new ResponseEntity<>(votingResource, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/topics/{topicId}/votings/{votingId}", method = RequestMethod.DELETE)
    public HttpStatus deleteAllVotingsByTopicId(@PathVariable Long topicId) {
        votingProxyService.deleteAllByTopicId(topicId);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/topics/{topicId}/votings", method = RequestMethod.GET)
    public HttpEntity<List<VotingResource>> getAllVotingsByTopicId(@PathVariable Long topicId) {
        List<VotingResource> votingResources = votingProxyService.getAllByTopicId(topicId);
        votingResources.forEach(votingLinkAssembly::addLinks);
        return new ResponseEntity<>(votingResources, HttpStatus.OK);
    }
}
