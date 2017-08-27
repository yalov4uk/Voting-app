package com.yalovchuk.web.utility.link.implementation;

import com.yalovchuk.resource.TopicResource;
import com.yalovchuk.web.controller._interface.TopicController;
import com.yalovchuk.web.controller.implementation.TopicControllerImpl;
import com.yalovchuk.web.utility.link._interface.TopicLinkAssembly;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class TopicLinkAssemblyImpl implements TopicLinkAssembly {

    @Override
    public void addLinks(TopicResource resource) {
        Long topicId = resource.getPk();
        resource.add(linkTo(methodOn(TopicControllerImpl.class).read(topicId)).withSelfRel());

    }
}
