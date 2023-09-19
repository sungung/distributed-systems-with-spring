## Why
POC of distributed microservice with spring cloud.

### Configuration server
SC Config provides a central place to manage external properties in a distributed system.

@EnableConfigServer annotation enables running configuration server

Try out client configuration by API
```
curl localhost:8088/gateway-service/default
```
### Service Discovery server
SC Eureka service registry provides client-side load-balancing and decouples service provides from consumers without the need for DNS.

@EnableEurekaServer annotation enables running Eureka service.

Eureka dashboard is available under the address http://localhost:8061/

### Inter-service communication
SC OpenFeign is a declarative REST client which is to facilitate communication between microservices. OpenFeign allows one microservice to call another as if it were a local method call.
Also, OpenFeign can discover and call services by logical names with Service Discovery.

@EnableFeignClients

## Build images & run
`mvn clean package -Pbuild-image` in each module directory
`docker-compose up`

## Test
```
curl -d '{"reference":"ORD001", "item":"apple", "qty":10}' -H "Content-Type: application/json" -X POST localhost:8060/order/
curl localhost:8060/order/ORD001
```
### Swagger UI
http://localhost:8060/swagger-ui.html

### Zipkin UI
http://localhost:9411/zipkin/

### If build is failed with status code 51
- Use java 17 or 20 version

## Scaling
docker compose up -d --scale inventory-service=2

When run the following service first time
```
curl -d '{"reference":"ORD001", "item":"apple", "qty":10}' -H "Content-Type: application/json" -X POST localhost:8060/order/
```
Then you can the following log in the first inventory instance.
```
distributed-systems-with-spring-inventory-service-1  | 2023-09-19T01:27:13.334Z  INFO 1 --- [nio-8080-exec-1] c.s.d.i.controller.InventoryController   : Checking inventory item apple
```
Then run the service again, you will see log in the second inventory instance


