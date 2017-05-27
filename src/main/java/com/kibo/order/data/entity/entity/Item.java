package com.kibo.order.data.entity.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    //TODO: Add fields here.
    private String name;

    private String upc;

    public Item() {}

    public Item(String name, String upc) {
        this.name = name;
        this.upc = upc;
    }
 }
