package com.example.herokuappdemo;


import com.example.herokuappdemo.DAO.UserDAO;
import com.example.herokuappdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class HerokuappDemoApplicationTests {

    @Autowired
    UserDAO userDAO;

    @Test
    void contextLoads() {


    }

    @Test
    void createUserTest() {

     /*   User userNew = new User("aknkya", "0000091", "admin", true);


        userDAO.save(userNew);

        User user = userDAO.findByUserName("aknkya");

        assertTrue(user.getUserName().equals(userNew.getUserName()));

        userDAO.delete(userNew);*/

    }

}
