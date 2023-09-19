package com.sandpit.ds.inventory.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Inventory {
    public Inventory() {
        this.status = "AVAILABLE";
    }

    @NotNull
    private String item;
    @NotNull
    private Integer qty;
    @NotNull
    private String status;
}
