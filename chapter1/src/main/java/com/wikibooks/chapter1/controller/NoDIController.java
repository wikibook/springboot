package com.wikibooks.chapter1.controller;

import com.wikibooks.chapter1.service.MyService;
import com.wikibooks.chapter1.service.MyServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoDIController {

    private MyService service = new MyServiceImpl();

    @GetMapping("/no-di/hello")
    public String getHello() {
        return service.getHello();
    }

}
