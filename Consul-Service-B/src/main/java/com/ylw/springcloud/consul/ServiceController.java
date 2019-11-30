package com.ylw.springcloud.consul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ServiceController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getorder")
    public String getOrder() {
        // order 使用rpc 远程调用技术 调用 会员服务
        String memberUrl = "http://consul-service-a/getMember";
        String result = restTemplate.getForObject(memberUrl, String.class);
        System.out.println("会员服务调用订单服务,result:" + result);
        return result;
    }

}
