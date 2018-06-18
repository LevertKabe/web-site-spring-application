package com.pnpStore.controller;

//imported files for PaymentController class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pnpStore.model.Payment;
import com.pnpStore.service.PaymentService;

//Marks that class is a Spring MVC Controller using REST API
@RestController 
public class PaymentController {
    
    //@Autowired - use annotation to get rid of the setter method eg private Name name = new NameImpl();
    //Object from Service - PaymentService
    @Autowired
    private PaymentService paymentService;
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    //@RequestMethod - method in which the request HTTP method ,POST - submits data to be processed 
    //@RequestBody Convert JSON 'Object' format to Object
    @RequestMapping(value="/savepayment", method = RequestMethod.POST)
    public void SavePayment(@RequestBody Payment payment)
    {
        paymentService.SaveCart(payment);
    }
}
