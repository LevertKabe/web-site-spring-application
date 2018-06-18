package com.pnpStore.repository;

import com.pnpStore.model.Customer;
import org.springframework.data.repository.CrudRepository;
import com.pnpStore.model.Product;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> 
{
    @Query("SELECT c FROM Product c WHERE c.prodname = :prodname")
    public Product getProdByName(@Param("prodname") String prodName);
    
    @Transactional
    @Modifying
    @Query("UPDATE Product c SET c.price = :price, c.categoryID = :catid , c.prodname = :prodname , c.prodinfo = :productinfo WHERE c.barcode = :barcode")
    public void updateProd(@Param("price") double price,
            @Param("catid") int catid,
            @Param("prodname") String prodname,
            @Param("productinfo") String productinfo,
            @Param("barcode") int barcode
            );
    
}
