package com.alvin.study.sc.demoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private DiscoveryClient client;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/test")
    public String test() {
        List<String> serviceNameList = client.getServices();
        return "hello," + serviceNameList.size() + "," + serverPort;
    }
}
