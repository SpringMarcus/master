package com.kibo.order.data.entity.entity;

import com.kibo.order.data.entity.entity.order.Order;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Address() {}
 }
