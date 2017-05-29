package com.kibo.order.data.entity.entity.orderitem;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orderitem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    //TODO: Add fields here.
    private String name;

    private String upc;

    public OrderItem() {}

    public OrderItem(String name, String upc) {
        this.name = name;
        this.upc = upc;
    }
 }
