package com.yalovchuk.web.utility.link.implementation;

import com.yalovchuk.resource.ItemResource;
import com.yalovchuk.web.controller.implementation.ItemControllerImpl;
import com.yalovchuk.web.controller.implementation.TopicControllerImpl;
import com.yalovchuk.web.controller.implementation.VotingControllerImpl;
import com.yalovchuk.web.utility.link._interface.ItemLinkAssembly;
import com.yalovchuk.web.utility.link._interface.VotingLinkAssembly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class ItemLinkAssemblyImpl implements ItemLinkAssembly {

    @Autowired
    private VotingLinkAssembly votingLinkAssembly;

    @Override
    public void addLinks(ItemResource resource) {
        Long itemId = resource.getPk();
        Long votingId = resource.getVoting().getPk();
        Long topicId = resource.getVoting().getTopic().getPk();
        resource.add(
                linkTo(methodOn(ItemControllerImpl.class).read(itemId)).withSelfRel(),
                linkTo(methodOn(VotingControllerImpl.class).read(votingId)).withRel("voting"),
                linkTo(methodOn(TopicControllerImpl.class).read(topicId)).withRel("topic")
        );
        votingLinkAssembly.addLinks(resource.getVoting());
    }
}
