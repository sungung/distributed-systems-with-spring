package com.sandpit.ds.order.model;

import lombok.Data;

@Data
public class Inventory {
    private String item;
    private Integer qty;
    private String status;
}
