package com.jsule.demo_xa_db.web;

import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final ProducerTemplate producerTemplate;

    public HelloController(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @RequestMapping("/")
    public String index() {
        producerTemplate.sendBody("direct:camelRoute","A message TODO");
        return "Greetings from Spring Boot!";
    }

}