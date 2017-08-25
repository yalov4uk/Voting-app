package com.yalovchuk.web.controller;

import com.yalovchuk.bean.Voting;
import com.yalovchuk.service.crud._interface.VotingService;
import com.yalovchuk.service.crud._interface.base.CrudService;
import com.yalovchuk.web.controller.base.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Deprecated
@RestController
@RequestMapping(value = "/votings")
public class VotingController extends CrudController<Voting, Long> {

    @Qualifier("votingServiceImpl")
    @Autowired
    private VotingService votingService;

    @Override
    protected CrudService<Voting, Long> getService() {
        return votingService;
    }
}
