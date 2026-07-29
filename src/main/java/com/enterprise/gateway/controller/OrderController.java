package com.enterprise.gateway.controller;
import com.enterprise.gateway.dto.OrderRequest;
import com.enterprise.gateway.exchange.DefaultExchange;
import com.enterprise.gateway.exchange.Exchange;
import com.enterprise.gateway.gateway.GatewayEngine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final GatewayEngine gateway;
    public OrderController(GatewayEngine gateway) {
        this.gateway = gateway;
    }

    @PostMapping
    public ResponseEntity<Object> createOrder(
            @RequestBody OrderRequest request,
            @RequestHeader("Authorization") String token,
            @RequestHeader("Role") String role) throws Exception {

        System.out.println("Controller Invoked");
        Exchange exchange = new DefaultExchange();
        exchange.getIn().setBody(request);
        exchange.getIn().setHeader("Authorization", token);
        exchange.getIn().setHeader("Role", role);
        System.out.println("Calling Gateway");
        gateway.process("/orders", exchange);
        System.out.println("Gateway Finished");
        return ResponseEntity.ok(exchange.getIn().getBody());
    }
}

 /**
import com.enterprise.gateway.dto.OrderRequest;
import com.enterprise.gateway.dto.OrderResponse;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ProducerTemplate producerTemplate;

    public OrderController(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @PostMapping
    public Object createOrder(
            @RequestBody OrderRequest request) {

        Exchange exchange =
                producerTemplate.request(
                        "direct:createOrder",
                        e -> e.getIn().setBody(request));

        return exchange.getMessage().getBody();
        //   return producerTemplate.requestBody(
        //         "direct:createOrder",
        //       request,
        //     OrderResponse.class);

    }

}
 */