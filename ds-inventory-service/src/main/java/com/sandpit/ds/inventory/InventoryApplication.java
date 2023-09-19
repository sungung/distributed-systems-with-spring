package com.sandpit.ds.inventory;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@OpenAPIDefinition(info =
    @Info(title = "Inventory API", version = "1.0", description = "Inventory API v1.0")
)
public class InventoryApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(InventoryApplication.class).run(args);
    }
}
