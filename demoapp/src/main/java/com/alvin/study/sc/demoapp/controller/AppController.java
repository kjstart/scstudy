package com.alvin.study.sc.demoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/test")
    public String test() {
        List<String> serviceNameList = client.getServices();
        return "hello," + serviceNameList.size() + "," + serviceNameList.get(0);
    }

}
