package com.pnpStore.controller;

//imported files for CartController class
import com.pnpStore.model.Cart;
import com.pnpStore.model.Customer;
import com.pnpStore.service.CartService;
import com.pnpStore.service.UserCartService;
import java.util.ArrayList;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//Marks that class is a Spring MVC Controller using REST API
@RestController 
public class CartController 
{
    //@Autowired - use annotation to get rid ofthe setter emthod eg private Name name = new NameImpl(); 
    @Autowired
    private CartService cartService;
    
    //@Autowired - use annotation to get rid ofthe setter emthod eg private Name name = new NameImpl(); 
    @Autowired
    private UserCartService userCartService;
    
    public String name = "";
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    //@RequestBody Convert JSON format to Object
    @ResponseBody
    public String currentCustID(Authentication authentication)
    {
        //getContectPath - 
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        name = auth.getName(); 
        return name;
    }
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    @RequestMapping(value = "/getId")
    public ArrayList<Customer> getUser(String Email)
    {
         ArrayList<Customer> listUser = userCartService.findUser(name);
        return listUser; 
    }
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    @RequestMapping(value="/saveCart", method = RequestMethod.POST)
    public void SaveCart(@RequestBody Cart cart)
    {
        cartService.SaveCart(cart);
    }
    
    //@RequestMapping- to map URLs such as /savesalesitem onto an entire class or a particular handler method
    @RequestMapping(value = "/viewCart", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    //@RequestBody Convert JSON format to Object
    @ResponseBody
    public ArrayList<Cart> getAllCart(String custID)
    {
        ArrayList<Cart> listCart = cartService.getAllCartItem(custID);
        return listCart;
    }
    
    @RequestMapping(value="/deleteCart", method = org.springframework.web.bind.annotation.RequestMethod.POST)
    //@RequestBody Convert JSON format to Object
    public void DeleteCart(@RequestBody Cart cart)
    {
        System.out.println(cart.getBarcode());
        System.out.println(cart.getCustID());
        cartService.DeleteCart(cart.getBarcode(), cart.getCustID());  
    }
    
    @RequestMapping(value="/deleteCartByCust", method = org.springframework.web.bind.annotation.RequestMethod.POST)
    public void DeleteCartByCust(@RequestBody Cart cart)
    {
        System.out.println(cart.getCustID());
        cartService.DeleteCartByCust(cart.getCustID());  
    }
    
}
