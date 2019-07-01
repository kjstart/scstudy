package com.alvin.study.sc.consumerapp.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;

    private String name = "";


    //Monitor Hystrix by: (Depends Hystrix-Dashboard)
    // http://localhost:9000/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A9000%2Factuator%2Fhystrix.stream
    // http://localhost:9000/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A9000%2Fturbine.stream

    @HystrixCommand(fallbackMethod = "helloFail", groupKey = "testGroup")
    @CacheResult
    public String hello(){
        return restTemplate.getForEntity("http://demo-app/app/test", String.class).getBody()+":"+name;
    }

    @CacheRemove(commandKey = "hello")
    public String writeName(String name){
        this.name = name;
        return name;
    }

    public String helloFail(){
        return "error,"+System.currentTimeMillis();
    }
}
