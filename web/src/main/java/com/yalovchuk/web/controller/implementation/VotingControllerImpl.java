package com.yalovchuk.web.controller.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.proxy._interface.VotingProxyService;
import com.yalovchuk.service.proxy._interface.base.CrudProxyService;
import com.yalovchuk.web.controller._interface.VotingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "topics/{topicId}/votings",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class VotingControllerImpl implements VotingController {

    @Autowired
    private VotingProxyService votingProxyService;

    @Override
    public CrudProxyService<Voting, Long, VotingDto, VotingResource> getService() {
        return votingProxyService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public HttpEntity<VotingResource> createVotingByTopicId(@PathVariable Long topicId,
                                                            @RequestBody VotingDto votingDto) {
        return new ResponseEntity<>(votingProxyService.createResourceByTopicId(topicId, votingDto), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public HttpStatus deleteAllVotingsByTopicId(@PathVariable Long topicId) {
        votingProxyService.deleteAllResourcesByTopicId(topicId);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HttpEntity<List<VotingResource>> getAllVotingsByTopicId(@PathVariable Long topicId) {
        return new ResponseEntity<>(votingProxyService.getAllResourcesByTopicId(topicId), HttpStatus.OK);
    }
}
