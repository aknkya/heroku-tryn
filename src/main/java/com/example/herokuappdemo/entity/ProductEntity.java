package com.example.herokuappdemo.entity;

import javax.persistence.*;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "productPrice")
    private Integer productPrice;

   @ManyToOne
   @JoinColumn(name="order_entity_id")
    private OrderEntity orderEntity;


    public ProductEntity() {
    }

    public ProductEntity(long id, String name, Integer productPrice) {
        this.id = id;
        this.name = name;
        this.productPrice = productPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
}
