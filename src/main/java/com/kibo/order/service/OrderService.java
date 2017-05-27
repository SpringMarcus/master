package com.kibo.order.service;

import com.kibo.order.data.entity.entity.Customer;
import com.kibo.order.data.entity.entity.Item;
import com.kibo.order.data.entity.entity.Order;
import com.kibo.order.data.repository.v2.CustomerRepository;
import com.kibo.order.data.repository.v2.ItemRepository;
import com.kibo.order.data.repository.v2.OrderRepository;
import com.kibo.order.util.status.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderService {
    
    @Autowired
    private CustomerRepository custRepo;

    @Autowired
    private ItemRepository itemRepo;

    @Autowired
    private OrderRepository orderRepo;
    
    public Item createItem(String upc, String name) {
        //TODO: Implement this
        Item item = new Item(name, upc);

        itemRepo.save(item);

        return item;
    }

    public Order createOrderInProgress(Customer c, List<Integer> items) {
        //TODO: Implement this.
        List<Item> orderItems = new ArrayList<Item>();

        for (Integer i : items) {
            Item item = itemRepo.findOne(i);
            orderItems.add(item);
        }

        Order order = new Order(c, OrderStatus.IN_PROGRESS, orderItems);
        return null;
    }
    
    public Order completeOrder(Order o) {
        //TODO: Implement this
        o.setOrderStatus(OrderStatus.FULFILLED);
        return o;
    }

    @Transactional(readOnly = true)
    public List<Item> getItemsForOrder(Order o) {
        //TODO: Implement this.
        return o.getOrderItems();
    }

    public Item findItemsByUpc(String upc) {
        //TODO: Implement this
        Iterable<Item> items = itemRepo.findAll();
        for(Item i : items) {
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

