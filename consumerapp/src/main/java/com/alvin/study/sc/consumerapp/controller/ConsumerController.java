package com.alvin.study.sc.consumerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET, value="/lbtest")
    public String testConsumer(){
//        return 1/0;
        return restTemplate.getForEntity("http://demo-app/app/test", String.class).getBody();
    }
}
