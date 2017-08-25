package com.yalovchuk.web.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.service.complex._interface.VotingComplexService;
import com.yalovchuk.service.crud._interface.ItemService;
import com.yalovchuk.service.crud._interface.TopicService;
import com.yalovchuk.service.crud._interface.VotingService;
import com.yalovchuk.service.crud._interface.base.CrudService;
import com.yalovchuk.web.controller.base.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/topics",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class TopicController extends CrudController<Topic, Long> {

    @Autowired
    private TopicService topicService;
    @Qualifier("votingServiceImpl")
    @Autowired
    private VotingService votingService;
    @Autowired
    private ItemService itemService;

    @Autowired
    private VotingComplexService votingComplexService;



    @RequestMapping(value = "/{topicId}/votings", method = RequestMethod.POST)
    public HttpEntity<Voting> create(@PathVariable Long topicId, @RequestBody Voting voting) {
        return new ResponseEntity<>(votingComplexService.create(topicId, voting), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{topicId}/votings", method = RequestMethod.GET)
    public HttpEntity<List<Voting>> getAll(@PathVariable Long topicId) {
        return new ResponseEntity<>(votingComplexService.getAll(topicId), HttpStatus.FOUND);
    }




    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public HttpEntity test() {
        TopicResource topicResource = new TopicResource(8L, "resource Test");
        //topicResource.add(linkTo(methodOn(TopicController.class).getAll()).withSelfRel());
        return new ResponseEntity(topicResource, HttpStatus.OK);
    }



    @Override
    protected CrudService<Topic, Long> getService() {
        return topicService;
    }
}
