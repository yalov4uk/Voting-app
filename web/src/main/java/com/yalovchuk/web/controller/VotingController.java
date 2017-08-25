package com.yalovchuk.web.controller;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.service.main._interface.VotingService;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.web.controller.base.CrudController;
import com.yalovchuk.web.controller.base.RudController;
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
public class VotingController extends RudController<Voting, Long> {

    @Autowired
    private VotingService votingService;

    @Override
    protected CrudService<Voting, Long> getService() {
        return votingService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public HttpEntity<Voting> createVotingByTopicId(@PathVariable Long topicId, @RequestBody Voting voting) {
        return new ResponseEntity<>(votingService.createByTopicId(topicId, voting), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public HttpStatus deleteAllVotingsByTopicId(@PathVariable Long topicId) {
        votingService.deleteAllByTopicId(topicId);
        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HttpEntity<List<Voting>> getAllVotingsByTopicId(@PathVariable Long topicId) {
        return new ResponseEntity<>(votingService.getAllByTopicId(topicId), HttpStatus.OK);
    }
}
