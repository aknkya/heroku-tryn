package com.example.herokuappdemo.DAO;

import com.example.herokuappdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {


    //  @Query("SELECT u FROM User u where u.userName=?1")
    // public User findByUserName(String username);


    User findByUserName(String userName);


}
