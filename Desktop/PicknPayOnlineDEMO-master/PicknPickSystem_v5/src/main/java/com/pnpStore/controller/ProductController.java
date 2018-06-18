package com.pnpStore.controller;

//imported files for ProductController class
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pnpStore.model.Product;
import com.pnpStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Marks that class is a Spring MVC Controller using REST API
@RestController
public class ProductController {
    //List of object
    public List<Product> productList = new ArrayList<>();

    //@Autowired use annotation to get rid of the setter method eg private Name name = new NameImpl();
    //Object from Service - ProductService
    @Autowired
    public ProductService productService;
   
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    @RequestMapping(value="/getProducts")
    public List<Product> getProducts()
    {
        productList = productService.getAllProducts();
        return productList;
    }
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    //@RequestMethod - method in which the request HTTP method ,POST - submits data to be processed
    //@RequestBody Convert JSON 'Object' format to Object
    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    public void saveProd(@RequestBody Product prod)
    {
        productService.saveProduct(prod);
    }
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    @RequestMapping(value="/getProductsByCart")
    public Product getProductsByCart()
    {
        Product prod = new Product();
        
        prod = productService.getProductsByBarcode(1);
        return prod;
    }
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    //@RequestMethod - method in which the request HTTP method ,DELETE - removes a specified resource
    //@PathVariable - identifies pattern used in URI for incoming data - reads '{x}'
    @RequestMapping(value="/deleteProduct/{barcode}", method = org.springframework.web.bind.annotation.RequestMethod.DELETE)
    public void DeleteCart(@PathVariable int barcode)
    {
        productService.DeleteProduct(barcode); 
    }
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    //@RequestMethod - specifies method in which the request HTTP method ,GET - requests a specified resource
    //@PathVariable - identifies pattern used in URI for incoming data - reads '{x}'
    @RequestMapping(value="/getProduct/{barcode}",  method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public void getProd(@PathVariable int barcode)
    {
        productService.getProductsByBarcode(barcode);
    }
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    //@RequestMethod - method in which the request HTTP method ,GET - requests a specified resource
    //@PathVariable - identifies pattern used in URI for incoming data - reads '{x}'
    @RequestMapping(value="/getCustByName/{prodName}",  method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public Product getProdByName(@PathVariable String prodName)
    {
        Product prod = new Product();
        
        prod = productService.getProductsByName(prodName);
        
        return prod;
    }
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    //@RequestMethod - method in which the request HTTP method ,PUT - puts a file or resource at a specific UR
    //@RequestBody Convert JSON 'Object' format to Object
    @RequestMapping(method = RequestMethod.PUT, value = "/updateProd")
    public void updateProd(@RequestBody Product prod)
    {
        System.out.println(prod.getPrice());
        productService.updateProd(prod);
    }
    
}
