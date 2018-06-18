package com.pnpStore.service;

import com.pnpStore.model.Customer;
import java.util.List;



public interface UserService {
    
	public Customer findUserByEmail(String email);
        //public String findIDByEmail(String email);
	public void saveUser(Customer user);
        public List<Customer> getAllCustomer();
        public Customer getCustomer(String custID);
        public void updateCust(Customer customer);
        public List<Customer>getAllCustomerNoAdmin();
      
}
