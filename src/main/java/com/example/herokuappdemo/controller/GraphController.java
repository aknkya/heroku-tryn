package com.example.herokuappdemo.controller;


import com.example.herokuappdemo.service.MovieRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GraphController {
    @Autowired
    MovieRequestService movieRequestService;


}
