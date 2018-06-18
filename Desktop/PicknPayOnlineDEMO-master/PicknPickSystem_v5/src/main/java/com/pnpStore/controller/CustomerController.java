package com.pnpStore.controller;

//imported files for CustomerController class
import com.pnpStore.model.Customer;
import com.pnpStore.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Marks that class is a Spring MVC Controller using REST API
@RestController

public class CustomerController {
    private String name ;
    
    //Authentication- takes the credintials provided and compares the to files within the Customer model and checks if tthey exists in the file system/Database
        public String getCust(Authentication authentication )
        {
            //Gets the name of the logged in ueer
            name = authentication.getName();
            return name;
        }
        
        //@Autowired - use annotation to get rid ofthe setter method eg private Name name = new NameImpl();
        //Object from Service - UserService
    	@Autowired
	private UserService userService;
        
        public List<Customer> customerList = new ArrayList<>();
        
        public Customer cust = new Customer();
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        @RequestMapping(value="/getCust")
        public List<Customer> getCust()
        {
            customerList = userService.getAllCustomer();
            return customerList;
        }
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        @RequestMapping(value="/getCustNoAdmin")
        public List<Customer> getCustNoAdmin()
        {
            customerList = userService.getAllCustomerNoAdmin();
            return customerList;
        }
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
        @RequestMapping(value="/getCustById", method = org.springframework.web.bind.annotation.RequestMethod.GET)
        public Customer getCustById()
        {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return userService.getCustomer(auth.getName());
        }
        
        //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
        @RequestMapping(method = RequestMethod.PUT, value = "/updateCust")
        //@RequestBody Convert JSON format to Object
        public void updateCust(@RequestBody Customer cust)
        {
            System.out.println(cust.getIdNo());
            userService.updateCust(cust);
        }
}
