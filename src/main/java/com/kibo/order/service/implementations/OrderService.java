package com.kibo.order.service.implementations;

import com.kibo.order.data.entity.entity.Customer;
import com.kibo.order.data.entity.entity.orderitem.OrderItem;
import com.kibo.order.data.entity.entity.order.Order;
import com.kibo.order.data.repository.jpa.CustomerRepository;
import com.kibo.order.data.repository.jpa.OrderItemRepository;
import com.kibo.order.data.repository.jpa.OrderRepository;
import com.kibo.order.data.entity.entity.order.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderService {
    
    @Autowired
    private CustomerRepository custRepo;

    @Autowired
    private OrderItemRepository itemRepo;

    @Autowired
    private OrderRepository orderRepo;
    
    public OrderItem createItem(String upc, String name) {
        //TODO: Implement this
        OrderItem orderItem = new OrderItem(name, upc);

        itemRepo.save(orderItem);

        return orderItem;
    }

    public Order createOrderInProgress(Customer c, List<Integer> items) {
        //TODO: Implement this.
        List<OrderItem> orderItems = new ArrayList<OrderItem>();

        for (Integer i : items) {
            OrderItem orderItem = itemRepo.findOne(i);
            orderItems.add(orderItem);
        }

        Order order = new Order(c, OrderStatus.IN_PROGRESS, orderItems);
        return null;
    }
    
    public Order completeOrder(Order o) {
        //TODO: Implement this
        o.setOrderStatus(OrderStatus.FULFILLED);
        return o;
    }

//    @Transactional(readOnly = true)
//    public List<OrderItem> getItemsForOrder(Order o) {
//        //TODO: Implement this.
//        return o.getOrderItems();
//    }

    public OrderItem findItemsByUpc(String upc) {
        //TODO: Implement this
        Iterable<OrderItem> items = itemRepo.findAll();
        for(OrderItem i : items) {
            if(i.getUpc() == upc) {
                return i;
            }
        }
        return null;
    }
    
    public List<Order> getInProgressOrdersForCustomer(Customer cust) {
        //TODO: Implement this
        List<Order> orders = cust.getOrders();
        List<Order> inProgressOrders = new ArrayList<>();

        for (Order o : orders) {
            if(o.getOrderStatus() == OrderStatus.IN_PROGRESS) {
                inProgressOrders.add(o);
            }
        }
        return inProgressOrders;
    }
}

