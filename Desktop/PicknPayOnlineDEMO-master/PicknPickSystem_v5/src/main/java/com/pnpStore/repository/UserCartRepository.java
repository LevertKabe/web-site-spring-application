package com.pnpStore.repository;

import org.springframework.stereotype.Repository;
import com.pnpStore.model.Customer;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserCartRepository extends CrudRepository<Customer, Integer> {
    
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    public ArrayList<Customer> getId(@Param("email") String email);
    
}
