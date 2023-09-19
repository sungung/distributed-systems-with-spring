package com.sandpit.ds.inventory.controller;

import com.sandpit.ds.inventory.model.Inventory;
import com.sandpit.ds.inventory.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class InventoryController {

    public static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    InventoryRepository repository;

    @PostMapping("/")
    public Inventory add(@RequestBody Inventory inventory){
        return repository.add(inventory);
    }

    @GetMapping("/{reference}")
    public Inventory find(@PathVariable("reference") String reference) {
        log.info("Checking inventory item " + reference);
        return repository.get(reference);
    }

}
