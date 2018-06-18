package com.pnpStore.service;

import com.pnpStore.model.Customer;
import com.pnpStore.repository.UserCartRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserCartService {
    
    @Autowired
	private UserCartRepository userRepository;
    
     public ArrayList<Customer> findUser(String email)
        {
		return userRepository.getId(email);
	}
}
