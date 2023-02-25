package com.example.herokuappdemo.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /*@Column(name="orderUser")
    private User user;*/


    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    private Set<ProductEntity> productList;



}
