package com.sandpit.ds.order.controller;

import com.sandpit.ds.order.client.InventoryService;
import com.sandpit.ds.order.model.Inventory;
import com.sandpit.ds.order.model.Order;
import com.sandpit.ds.order.repository.OrderRepository;
import feign.Response;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    OrderRepository repository;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CircuitBreakerFactory circuitBreakerFactory;

    @PostMapping("/")
    public ResponseEntity add(@RequestBody Order order){
        log.info("Order has received, order details " + order.toString());
        Inventory inventory = inventoryService.findInventory(order.getItem());
        if (inventory == null || inventory.getQty() < order.getQty()) {
            return ResponseEntity.badRequest().body("Not enough inventory");
        }
        order = repository.add(order);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{reference}")
    public Order find(@PathVariable("reference") String reference) {
        return repository.get(reference);
    }

    @GetMapping("/slow/{delay}")
    public ResponseEntity slowApi(@PathVariable("delay") int seconds){
        //return restTemplate.getForEntity("https://httpbin.org/delay/{seconds}", Map.class, seconds);
        return circuitBreakerFactory.create("slow").run(
                () -> restTemplate.getForEntity("https://httpbin.org/delay/{seconds}", Map.class, seconds), t -> {
                    log.warn("Slow API", t);
                    return ResponseEntity.ok("Fallback");
                }
        );
    }
}
