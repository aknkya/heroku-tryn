package com.example.herokuappdemo.controller;


import org.apache.juli.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

@RestController
public class LoggingController {


private static final Logger LOG= LoggerFactory.getLogger(LoggingController.class);
    @GetMapping("/loginfo")
    public String getFirstLog(){
        LOG.info("deneme");
        return "log İnfo Worked";
    }
}
