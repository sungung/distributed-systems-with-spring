package com.sandpit.ds.order.client;

import com.sandpit.ds.order.model.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryService {

    @GetMapping("/{item}")
    Inventory findInventory(@PathVariable("item") String item);
}
