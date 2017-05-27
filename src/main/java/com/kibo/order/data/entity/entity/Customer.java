package com.kibo.order.data.entity.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //TODO: Add more fields here.
    private String email;

    private String name;

    private String address;

    private String city;

    private String state;

    private String zip;

    private String phone;

    @OneToMany
    private List<Order> orders;
    
    public Customer() {}
 }
