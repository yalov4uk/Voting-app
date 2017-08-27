package com.yalovchuk.web.utility.link.implementation;

import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.web.controller.implementation.TopicControllerImpl;
import com.yalovchuk.web.controller.implementation.VotingControllerImpl;
import com.yalovchuk.web.utility.link._interface.TopicLinkAssembly;
import com.yalovchuk.web.utility.link._interface.VotingLinkAssembly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class VotingLinkAssemblyImpl implements VotingLinkAssembly {

    @Autowired
    private TopicLinkAssembly topicLinkAssembly;

    @Override
    public void addLinks(VotingResource resource) {
        Long votingId = resource.getPk();
        Long topicId = resource.getTopic().getPk();
        resource.add(
                linkTo(methodOn(VotingControllerImpl.class).readVotingByTopicIdAndId(topicId, votingId)).withSelfRel(),
                linkTo(methodOn(TopicControllerImpl.class).read(topicId)).withRel("topic")
        );
        topicLinkAssembly.addLinks(resource.getTopic());
    }
}
