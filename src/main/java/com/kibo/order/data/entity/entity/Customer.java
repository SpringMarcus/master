package com.kibo.order.data.entity.entity;

import com.kibo.order.data.entity.entity.order.Order;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //TODO: Add more fields here.
    private String email;

    private String name;

    private String addressId;

    @OneToMany
    private List<Order> orders;
    
    public Customer() {}
 }
