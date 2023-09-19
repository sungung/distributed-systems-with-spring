package com.sandpit.ds.order.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Order {
    public Order() {
        this.status = "PENDING";
    }

    @NotNull
    private String reference;
    @NotNull
    private String item;
    @NotNull
    private Integer qty;
    @NotNull
    private String status;
}
