package com.example.herokuappdemo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
   @Column(name = "username" ,unique = true)
   private String userName;
   @Column(name ="password")
   private String password;
   @Column(name="role",unique = true)
   private String role;
   @Column(name = "isActive")
   private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public User() {
    }

    public User(String userName, String password, String role, boolean isActive) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if(role.isEmpty() || role=="")
            role="user";

        this.role = role;
    }
}
