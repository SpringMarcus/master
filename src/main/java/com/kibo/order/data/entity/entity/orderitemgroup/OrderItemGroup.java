package com.kibo.order.data.entity.entity.orderitemgroup;

import com.kibo.order.data.entity.entity.order.Order;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "order_item_group")
public class OrderItemGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public OrderItemGroup() {}
 }
