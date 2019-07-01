package com.alvin.study.sc.consumerapp.controller;

import com.alvin.study.sc.consumerapp.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    TestService testService;

    @RequestMapping(method = RequestMethod.GET, value="/lbtest")
    public String testConsumer(){
        return testService.hello();
    }

    @RequestMapping(method = RequestMethod.GET, value="/name/{name}")
    public String testConsumer(@PathVariable String name){
        return testService.writeName(name);
    }


}
