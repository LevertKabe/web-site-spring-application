package com.pnpStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pnpStore.model.Inventoryitem;
import com.pnpStore.repository.InventoryitemRepository;

@Service
public class InventoryitemService {
    
    @Autowired
    public InventoryitemRepository itemRepository;
    
        public Inventoryitem saveItem(Inventoryitem item)
        {
            return itemRepository.save(item);   
        }
        
        public Inventoryitem getInventoryitem(int barcode)
        {
            return itemRepository.viewByInventoryItem(barcode);
        }
}
