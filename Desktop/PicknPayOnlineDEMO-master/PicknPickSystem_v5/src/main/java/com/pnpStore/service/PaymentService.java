package com.pnpStore.service;

import com.pnpStore.model.Payment;
import com.pnpStore.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    public PaymentRepository paymentRepository;
    

    public void SaveCart(Payment payment)
    {
        paymentRepository.save(payment);
    }
    
    
}
