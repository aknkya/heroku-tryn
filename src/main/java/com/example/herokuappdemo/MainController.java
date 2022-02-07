package com.example.herokuappdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    EntityDAO entityDAO;
    @GetMapping("/")
    public String getMainPage(){
        ClassEntity entity=new ClassEntity("AKIN","REIS",true);

        entityDAO.save(entity);
        System.out.println("Yazdı");
        List<ClassEntity> listEveryone =entityDAO.findAll();
        return listEveryone.toString();

    }
}
