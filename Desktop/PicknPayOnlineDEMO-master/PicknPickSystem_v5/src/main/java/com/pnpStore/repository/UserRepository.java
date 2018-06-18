package com.pnpStore.repository;

import org.springframework.stereotype.Repository;
import com.pnpStore.model.Customer;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository("UserRepository")
public interface UserRepository extends CrudRepository<Customer, Integer>
{
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    public Customer viewByUserId(@Param("email") String email);
    
    @Transactional
    @Modifying
    @Query("UPDATE Customer c SET c.active = :active , c.cellno = :cellno , c.email = :email , c.idNo = :idno , c.lastName = :sname , c.name = :fname , c.title = :title WHERE c.custID = :custid")
    public void updateCust(@Param("custid") int custID,
                                @Param("active") int active,
                                @Param("cellno") int cellno,
                                @Param("email") String email,
                                @Param("idno") int idno,
                                @Param("sname") String sname,
                                @Param("fname") String fname,
                                @Param("title") String title
                                );
    
    
    @Query("SELECT c FROM Customer c WHERE c.active = 1")
    public List<Customer> viewCust();
}
