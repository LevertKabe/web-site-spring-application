package com.pnpStore.controller;

//imported files for CustomerController class
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pnpStore.model.Product;
import com.pnpStore.service.ProductService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pnpStore.service.LocationService;
import com.pnpStore.model.Location;
import org.springframework.beans.factory.annotation.Autowired;

//Marks that class is a Spring MVC Controller using REST API
@RestController 
public class LocationController {
    
    //@Autowired - use annotation to get rid of the setter method eg private Name name = new NameImpl();
    //Object from Service - PaymentService
    @Autowired
    private LocationService locationService;
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    //@RequestMethod - method in which the request HTTP method ,POST - submits data to be processed 
    //@RequestBody Convert JSON 'Object' format to Object
    
    @RequestMapping(value="/savelocation", method = RequestMethod.POST)
    public void SaveLocation(@RequestBody Location location)
    {
        locationService.SaveLocation(location);
    }
}
