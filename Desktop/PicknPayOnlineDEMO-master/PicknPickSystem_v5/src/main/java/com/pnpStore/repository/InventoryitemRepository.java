package com.pnpStore.repository;

import org.springframework.data.repository.CrudRepository;
import com.pnpStore.model.Inventoryitem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryitemRepository extends CrudRepository<Inventoryitem, Integer> {
    
    
    @Query("SELECT c FROM Inventoryitem c WHERE c.barcode = :barcode")
    public Inventoryitem viewByInventoryItem(@Param("barcode") int barcode);
}
