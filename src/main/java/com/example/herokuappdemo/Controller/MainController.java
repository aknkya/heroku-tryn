package com.example.herokuappdemo.Controller;

import com.example.herokuappdemo.DAO.EntityDAO;
import com.example.herokuappdemo.DAO.UserDAO;
import com.example.herokuappdemo.Entity.ClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    EntityDAO entityDAO;
    @Autowired
    UserDAO userDAO;
    @GetMapping("/xxx")
    @ResponseBody
    public String getMainPage(){
        ClassEntity entity=new ClassEntity("AKIN","REIS",true);

        entityDAO.save(entity);
        System.out.println("Yazdı");
        List<ClassEntity> listEveryone =entityDAO.findAll();
        return listEveryone.toString();

    }

    @GetMapping("/login")
    public String getIndex(){

        return "index";
    }
    @GetMapping("/getquery")
    public String homePage(){

        return "akinjquery";
    }

    @GetMapping("/register")
    public String registerPage(){


        return "registerpage";
    }



    @PostMapping("/registernow")
    public String registerPost(@RequestParam(value = "username",required = false) String username,
                               @RequestParam(value = "password" ,required = false)String password){

        System.out.println(username+"  "+password);
    return "deneme";
}

}