package com.pnpStore.repository;

import com.pnpStore.model.Cart;
import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> 
{  
    @Query("SELECT l FROM Cart l WHERE l.cart_id = :cart_id")
    public ArrayList<Cart> viewByUserID(@Param("cart_id") int cart_id);
    
    
    @Transactional
    @Modifying
    @Query("DELETE FROM Cart c WHERE c.barcode = :barcode AND c.custID = :cust_id")
    public void deleteCart(@Param("barcode") int barcode,
            @Param("cust_id") String cust_id );
    
   
    @Transactional
    @Modifying
    @Query("DELETE FROM Cart c WHERE c.custID = :cust_id")
    public void deleteCartByCust(@Param("cust_id") String cust_id );        
}
