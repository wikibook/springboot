package com.wikibooks.chapter1.controller;

import com.wikibooks.chapter1.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class SetterInjectionController {

        MyService myService;

        @Autowired
        public void setMyService(MyService myService) {
            this.myService = myService;
        }

    }
