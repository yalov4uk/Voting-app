package com.yalovchuk.web.controller.implementation;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.dto.TopicDto;
import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.service.complex._interface.TopicComplexService;
import com.yalovchuk.service.complex._interface.mixin.CrudComplexService;
import com.yalovchuk.web.controller._interface.TopicController;
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
public class TopicControllerImpl implements TopicController {

    @Autowired
    private TopicComplexService topicComplexService;

    @Override
    public CrudComplexService<Topic, Long, TopicDto, TopicResource> getService() {
        return topicComplexService;
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public HttpEntity test() {
        TopicResource topicResource = new TopicResource(8L, "resource Test");
        topicResource.add(linkTo(methodOn(TopicControllerImpl.class).getAll()).withSelfRel());
        return new ResponseEntity<>(topicResource, HttpStatus.OK);
    }
}
