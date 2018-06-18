package com.pnpStore.repository;

import com.pnpStore.model.Order_item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order_item, Integer> {
    
}
