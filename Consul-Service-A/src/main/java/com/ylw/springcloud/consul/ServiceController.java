package com.ylw.springcloud.consul;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @RequestMapping("/getMember")
    public String getMember() {
        return "this is getMember";
    }

}
