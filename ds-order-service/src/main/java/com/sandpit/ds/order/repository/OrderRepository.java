package com.sandpit.ds.order.repository;

import com.sandpit.ds.order.model.Order;

import java.util.List;

public interface OrderRepository {
    Order add(Order order);
    void remove(String reference);
    List<Order> list();
    Order get(String reference);
}
