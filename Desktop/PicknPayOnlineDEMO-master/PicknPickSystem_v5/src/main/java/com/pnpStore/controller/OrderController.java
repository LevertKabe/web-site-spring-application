package com.pnpStore.controller;

//imported files for OrderController class
import com.pnpStore.model.Order_item;
import com.pnpStore.service.OrderService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Marks that class is a Spring MVC Controller using REST API
@RestController
public class OrderController {
    
    //@Autowired - use annotation to get rid ofthe setter emthod eg private Name name = new NameImpl();
    //Object from Service - OrderService
    @Autowired
    private OrderService orderService;
    
    //Store a list of Order_item objects
    public List<Order_item> orderList = new ArrayList<>();
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    //@RequestMethod - method in which the request HTTP method ,POST - submits data to be processed
    //@RequestBody Convert JSON 'Object' format to Object
    @RequestMapping(value="saveOrder", method = RequestMethod.POST)
    public void SaveOrder(@RequestBody Order_item order)
    {
        orderService.SaveOrder(order);
    }
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    @RequestMapping(value="/getAllOrders")
    public List<Order_item> getAllOrders()
    {
        orderList = orderService.getAllOrders();
        return orderList;
    }
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    //@RequestMethod - method in which the request HTTP method ,POST - submits data to be processed
    //@PathVariable - identifies pattern used in URI for incoming data - reads '{x}'
    @RequestMapping(value="/deleteOrder/{orderno}", method = org.springframework.web.bind.annotation.RequestMethod.POST)
    public void DeleteOrder(@PathVariable int orderno)
    {
        System.out.println(orderno);
        orderService.DeleteOrder(orderno);  
    }    
}
