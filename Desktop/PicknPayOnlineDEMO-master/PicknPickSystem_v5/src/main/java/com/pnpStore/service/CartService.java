package com.pnpStore.service;

import com.pnpStore.model.Cart;
import com.pnpStore.repository.CartRepository;
import com.pnpStore.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartService {
    @Autowired
    public CartRepository cartRepository;
    
    @Autowired
    public UserRepository userRepository;
    
    public void SaveCart(Cart cart)
    {
        cartRepository.save(cart);
    }
    
    public ArrayList<Cart> getAllCartItem(String custID)
    {
        ArrayList<Cart> cart = new ArrayList<>();
        cartRepository.findAll().
        forEach(cart::add);
        return cart;
    }
    
    public void DeleteCart(int barcode, String cust_id)
    {
        cartRepository.deleteCart(barcode, cust_id);
    }
    
        
    public void DeleteCartByCust(String cust_id)
    {
        cartRepository.deleteCartByCust(cust_id);
    }
    
}
