package com.pnpStore.controller;

//imported files for InventoryitemController class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pnpStore.model.Inventoryitem;
import com.pnpStore.service.InventoryitemService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

//Marks that class is a Spring MVC Controller using REST API
@RestController
public class InventoryitemController {
    
    //@Autowired use annotation to get rid ofthe setter emthod eg private Name name = new NameImpl();
    //Object from Service - InventoryitemService
    @Autowired
    public InventoryitemService itemService;
   
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    @RequestMapping(value="/addInventory", method = RequestMethod.POST)
    //@RequestBody Convert JSON 'Object' format to Java Object
    public void saveProd(@RequestBody Inventoryitem item)
    {
        itemService.saveItem(item);
    }
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    //@PathVariable - identifies pattern used in URI for incoming data - reads '{x}'
    //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
    @RequestMapping(value="/getinventoryItem/{barcode}",  method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public Inventoryitem getQuantityByBarcode(@PathVariable int barcode)
    {
        Inventoryitem inventoryItem = new Inventoryitem();
        inventoryItem = itemService.getInventoryitem(barcode);
        return inventoryItem;
    }
    
}
