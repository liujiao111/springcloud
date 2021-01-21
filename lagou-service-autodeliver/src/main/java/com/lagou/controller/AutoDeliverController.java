package com.lagou.controller;


import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/autodeliver", produces = "application/json")
public class AutoDeliverController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        /*Integer forObject =
                restTemplate.getForObject("http://localhost:8080/resume/openstate/"
                        + userId, Integer.class);
        System.out.println("======>>>调⽤简历微服务，获取到⽤户" +
                userId + "的默认简历当前状态为：" + forObject);*/

        //获取注册中心中的实例列表
        final List<ServiceInstance> instances = discoveryClient.getInstances("lagou-service-resume");
        //获取实例（此处不考虑负载，直接取第一个）
        final ServiceInstance instance = instances.get(0);
        //根据实例的信息拼接请求地址
        final String ipAddr = instance.getHost();
        final int port = instance.getPort();
        String url = "http://" + ipAddr + ":" + port + "/resume/openstate/" + userId;
        Integer forObject =
                restTemplate.getForObject(url, Integer.class);
        System.out.println("======>>>调⽤简历微服务，获取到⽤户" +
                userId + "的默认简历当前状态为：" + forObject);
        return forObject;
    }
}
