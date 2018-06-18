package com.pnpStore.service;

import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.pnpStore.model.Role;
import com.pnpStore.model.Customer;
import com.pnpStore.repository.RoleRepository;
import com.pnpStore.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;


@Service("customerService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
        private RoleRepository roleRepository;
        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        @Override
	public Customer findUserByEmail(String email)
        {
		return userRepository.viewByUserId(email);
	}
        
        @Override
	public void saveUser(Customer user) 
        {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setActive(1);
            Role userRole = roleRepository.findByRole("CUSTOMER");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            userRepository.save(user);
	}  
        
        @Override
        public List<Customer> getAllCustomer()
        {
            List<Customer> cust = new ArrayList<>();
            
            userRepository.findAll().
            forEach(cust::add);
       
            return cust;
        }
        
        @Override
        public Customer getCustomer(String custid)
        {
            return userRepository.viewByUserId(custid);
        }
        
        @Override
        public List<Customer>getAllCustomerNoAdmin()
        {
            return userRepository.viewCust();
        }
 
        @Override
        @Transactional
        public void updateCust(Customer customer)
        {
            int idNum = customer.getIdNo();
            int custid = customer.getCustID();
            int active = customer.getActive();
            int cellno = customer.getCellno();
            String email = customer.getEmail();
            String fname = customer.getName();
            String sname = customer.getLastName();
            String title = customer.getTitle();
               
            userRepository.updateCust(custid,active , cellno, email,idNum ,sname,fname, title);
        }
        
}
