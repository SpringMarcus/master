package com.kibo.order.data.entity.entity.order;

import com.kibo.order.data.entity.entity.Customer;
import com.kibo.order.data.entity.entity.orderitem.OrderItem;
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

//    @ManyToMany
//    @JoinTable(name = "order_item",
//            joinColumns = @JoinColumn(name = "orderID", referencedColumnName = "orderID"),
//            inverseJoinColumns = @JoinColumn(name = "itemID", referencedColumnName = "itemID"))
//    private List<OrderItem> orderItems;

    public Order() {}

    public Order(Customer customer, OrderStatus orderStatus, List<OrderItem> orderItems) {
        this.customer = customer;
        this.orderStatus = orderStatus;
//        this.orderItems = orderItems;
    }
 }
