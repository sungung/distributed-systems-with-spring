package com.sandpit.ds.inventory.repository;

import com.sandpit.ds.inventory.model.Inventory;
import java.util.List;

public interface InventoryRepository {
    Inventory add(Inventory inventory);
    void remove(String reference);
    List<Inventory> list();
    Inventory get(String reference);
}
