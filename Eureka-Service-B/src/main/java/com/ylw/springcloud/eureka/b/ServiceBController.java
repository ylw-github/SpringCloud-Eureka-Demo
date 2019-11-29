package com.ylw.springcloud.eureka.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceBController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getorder")
    public String getOrder() {
        // order 使用rpc 远程调用技术 调用 会员服务
        String memberUrl = "http://app-service-a/getMember";
        String result = restTemplate.getForObject(memberUrl, String.class);
        System.out.println("会员服务调用订单服务,result:" + result);
        return result;
    }
}
