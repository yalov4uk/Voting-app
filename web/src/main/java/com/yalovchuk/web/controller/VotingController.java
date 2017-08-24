package com.yalovchuk.web.controller;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.service.main._interface.VotingService;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.web.controller.base.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/votings")
public class VotingController extends CrudController<Voting, Long> {

    @Autowired
    private VotingService votingService;

    @Override
    protected CrudService<Voting, Long> getService() {
        return votingService;
    }
}
