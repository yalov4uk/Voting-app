package com.yalovchuk.web.controller;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.service.main._interface.TopicService;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.web.controller.base.mixin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(
        value = "/topics",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class TopicController implements
        CreateController<Topic, Long>,
        ReadController<Topic, Long>,
        UpdateController<Topic, Long>,
        DeleteController<Topic, Long>,
        GetAllController<Topic, Long> {

    @Autowired
    private TopicService topicService;

    @Override
    public CrudService<Topic, Long> getService() {
        return topicService;
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public HttpEntity test() {
        TopicResource topicResource = new TopicResource(8L, "resource Test");
        topicResource.add(linkTo(methodOn(TopicController.class).getAll()).withSelfRel());
        return new ResponseEntity<>(topicResource, HttpStatus.OK);
    }

}
