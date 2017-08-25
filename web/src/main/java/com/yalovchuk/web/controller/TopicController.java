package com.yalovchuk.web.controller;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.bean.Voting;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.service.main._interface.ItemService;
import com.yalovchuk.service.main._interface.TopicService;
import com.yalovchuk.service.main._interface.VotingService;
import com.yalovchuk.service.main._interface.base.CrudService;
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




    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public HttpEntity test() {
        TopicResource topicResource = new TopicResource(8L, "resource Test");
        //topicResource.add(linkTo(methodOn(TopicController.class).getAllByTopicId()).withSelfRel());
        return new ResponseEntity(topicResource, HttpStatus.OK);
    }



    @Override
    protected CrudService<Topic, Long> getService() {
        return topicService;
    }
}
