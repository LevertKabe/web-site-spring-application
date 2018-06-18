package com.pnpStore.service;

import com.pnpStore.repository.SalesItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.pnpStore.model.SalesItems;
import org.springframework.stereotype.Service;

@Service
public class SalesItemServices {
    
    @Autowired
    public SalesItemRepository salesRepository;
    
    public void savesalesitem(SalesItems salesItem)
    {
        salesRepository.save(salesItem);
    }
    
}
