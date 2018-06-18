package com.pnpStore.controller;

//imported files for SalesItemController class
import org.springframework.web.bind.annotation.RequestMapping;
import com.pnpStore.model.SalesItems;
import com.pnpStore.service.SalesItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController - Marks that class is a Spring MVC Controller using REST API
@RestController
public class SalesItemController 
{
    //@Autowired - use annotation to get rid ofthe setter emthod eg private Name name = new NameImpl();
    //Object from Service - SalesItemServices
    @Autowired
    private SalesItemServices salesItemService;
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    //RequestMethod - method in which the request HTTP method ,POST - submits data to be processed
    //@RequestBody Convert JSON 'Object' format to Object
    @RequestMapping(value="/savesalesitem", method = RequestMethod.POST)
    public void savesalesitem(@RequestBody SalesItems salesItem)
    {
        salesItemService.savesalesitem(salesItem);
    }
    
}
