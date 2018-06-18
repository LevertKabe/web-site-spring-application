package com.pnpStore.service;

import com.pnpStore.model.Order_item;
import com.pnpStore.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    public OrderRepository orderRepository;
    
    public void SaveOrder(Order_item order)
    {
        orderRepository.save(order);
    }
    
    public List<Order_item> getAllOrders()
   {
        List<Order_item> ord = new ArrayList<>();
        orderRepository.findAll().
        forEach(ord::add);
        return ord;
    }
    
    public void DeleteOrder(int orderno)
    {
        orderRepository.delete(orderno);
    }
    
}
