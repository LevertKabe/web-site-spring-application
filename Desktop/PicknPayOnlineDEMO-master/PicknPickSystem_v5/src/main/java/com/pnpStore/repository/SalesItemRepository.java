
package com.pnpStore.repository;

import com.pnpStore.model.Customer;
import org.springframework.data.repository.CrudRepository;
import com.pnpStore.model.Product;
import com.pnpStore.model.SalesItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SalesItemRepository extends CrudRepository<SalesItems, Integer> 
{
    
}
