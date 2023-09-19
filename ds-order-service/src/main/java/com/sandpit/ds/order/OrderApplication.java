package com.sandpit.ds.order;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.sandpit.ds.order.client")
@OpenAPIDefinition(info =
    @Info(title = "Order API", version = "1.0", description = "Order API v1.0")
)
public class OrderApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(OrderApplication.class).run(args);
    }
}
