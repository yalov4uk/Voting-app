package com.yalovchuk.web.controller.implementation;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.dto.VotingDto;
import com.yalovchuk.resource.VotingResource;
import com.yalovchuk.service.proxy._interface.VotingProxyService;
import com.yalovchuk.service.proxy._interface.base.CrudProxyService;
import com.yalovchuk.web.controller._interface.VotingController;
import com.yalovchuk.web.controller.implementation.base.CrudControllerImpl;
import com.yalovchuk.web.utility.link._interface.VotingLinkAssembly;
import com.yalovchuk.web.utility.link._interface.base.LinkAssembly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "api/v1/votings",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class VotingControllerImpl extends CrudControllerImpl<Voting, Long, VotingDto, VotingResource>
        implements VotingController {

    @Autowired
    private VotingProxyService votingProxyService;
    @Autowired
    private VotingLinkAssembly votingLinkAssembly;

    @Override
    protected CrudProxyService<Voting, Long, VotingDto, VotingResource> getService() {
        return votingProxyService;
    }

    @Override
    protected LinkAssembly<Voting, Long, VotingResource> getLinkAssembly() {
        return votingLinkAssembly;
    }

    @RequestMapping(value = "/{votingId}", method = RequestMethod.POST)
    public HttpEntity<VotingResource> enableVoting(@RequestParam Boolean enable, @PathVariable Long votingId) {
        VotingResource votingResource = votingProxyService.enableVoting(enable, votingId);
        addLinks(votingResource);
        return new ResponseEntity<>(votingResource, HttpStatus.OK);
    }
}
