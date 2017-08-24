package com.yalovchuk.web.controller;

import com.yalovchuk.bean.Topic;
import com.yalovchuk.service.main._interface.TopicService;
import com.yalovchuk.service.main._interface.base.CrudService;
import com.yalovchuk.web.controller.base.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/topics")
public class TopicController extends CrudController<Topic, Long> {

    @Autowired
    private TopicService topicService;

    @Override
    protected CrudService<Topic, Long> getService() {
        return topicService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return encryptor.decrypt(encryptor.encrypt(getService().getAll().toString()));
    }
}
