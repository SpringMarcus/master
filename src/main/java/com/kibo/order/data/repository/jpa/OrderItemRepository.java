package com.kibo.order.data.repository.jpa;

import com.kibo.order.data.entity.entity.orderitem.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
//TODO: Something important is missing from this repo...
}
