package com.kibo.order.data.entity.entity;

import com.kibo.order.util.status.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Customer customer;

    private OrderStatus orderStatus;

    @ManyToMany
    @JoinTable(name = "orderItems",
            joinColumns = @JoinColumn(name = "orderID", referencedColumnName = "orderID"),
            inverseJoinColumns = @JoinColumn(name = "itemID", referencedColumnName = "itemID"))
    private List<Item> orderItems;

    public Order() {}

    public Order(Customer customer, OrderStatus orderStatus, List<Item> orderItems) {
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.orderItems = orderItems;
    }
 }
