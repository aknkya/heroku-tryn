package com.example.herokuappdemo.Controller;

import com.example.herokuappdemo.DAO.EntityDAO;
import com.example.herokuappdemo.DAO.UserDAO;
import com.example.herokuappdemo.Entity.ClassEntity;
import com.example.herokuappdemo.Entity.User;
import com.example.herokuappdemo.Service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
   private MailSenderService mailSender;

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

    @GetMapping("/")
    public String getMainPages(){

        return "landingpage";
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


        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String enCodedPassowrd=bCryptPasswordEncoder.encode(password);

        User user =new User(username,enCodedPassowrd,"user",true);
         userDAO.save(user);

         if(userDAO.findByUserName(username) !=null && !userDAO.findByUserName(username).getUserName().isEmpty()){
             mailSender.sendMail("akn_kya@hotmail.com","Yeni üye kaydı",username+"  Isımlı Uye Sısteme Kayıt Olmustur Sıfresı: "+ password);
              List<User> userList= userDAO.findAll();
              mailSender.sendMail("akn_kya@hotmail.com","uye listesi",userList.toString());



         }


    return "index";
}

}
