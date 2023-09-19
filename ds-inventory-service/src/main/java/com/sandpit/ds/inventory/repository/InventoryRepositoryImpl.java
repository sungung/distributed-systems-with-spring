package com.sandpit.ds.inventory.repository;

import com.sandpit.ds.inventory.model.Inventory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component("inventoryRepository")
public class InventoryRepositoryImpl implements InventoryRepository {

    private static final int BASE_CREDIT = 30;

    private Map<String, Inventory> inventories = new TreeMap<>();

    @Override
    public synchronized Inventory add(Inventory inventory) {
        if (inventories.containsKey(inventory.getItem())) {
            throw new IllegalStateException("Inventory already proceeded");
        }

        inventories.put(inventory.getItem().toLowerCase(), inventory);
        return inventory;
    }

    @Override
    public synchronized void remove(String reference) {
        inventories.remove(reference);
    }

    @Override
    public List<Inventory> list() {
        return new ArrayList<>(this.inventories.values());
    }

    @Override
    public Inventory get(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        return inventories.get(item.toLowerCase());
    }
}
