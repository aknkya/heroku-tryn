package com.example.herokuappdemo.controller;


import com.example.herokuappdemo.service.RequestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController

public class RestControllerExample {
 private final RequestService requestService;

    public RestControllerExample(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/asd")
    public void getX() throws IOException, InterruptedException {
       String s = requestService.getServices();
        System.out.println(s);


    }



}
