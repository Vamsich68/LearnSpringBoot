package com.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController {
    @Autowired
    private Configurationservice configurationservice;
    @RequestMapping("/configure-service")
    public Configurationservice retrieveservices() {
        return configurationservice;
    }
}
