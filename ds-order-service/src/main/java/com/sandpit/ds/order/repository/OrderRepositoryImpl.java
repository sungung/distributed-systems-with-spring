package com.sandpit.ds.order.repository;

import com.sandpit.ds.order.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component("orderRepository")
public class OrderRepositoryImpl implements OrderRepository {

    private static final int BASE_CREDIT = 30;

    private Map<String, Order> orders = new TreeMap<>();

    @Override
    public synchronized Order add(Order order) {
        if (orders.containsKey(order.getReference())) {
            throw new IllegalStateException("Order already proceeded");
        }

        orders.put(order.getReference().toLowerCase(), order);
        return order;
    }

    @Override
    public synchronized void remove(String reference) {
        orders.remove(reference);
    }

    @Override
    public List<Order> list() {
        return new ArrayList<>(this.orders.values());
    }

    @Override
    public Order get(String reference) {
        if (reference == null) {
            throw new IllegalArgumentException("Refernce cannot be null");
        }
        return orders.get(reference.toLowerCase());
    }
}
