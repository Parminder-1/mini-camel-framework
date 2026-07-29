package com.enterprise.gateway.config;
import com.enterprise.gateway.component.HttpComponent;
import com.enterprise.gateway.component.KafkaComponent;
import com.enterprise.gateway.context.CamelContext;
import com.enterprise.gateway.context.DefaultCamelContext;
import com.enterprise.gateway.gateway.GatewayEngine;
import com.enterprise.gateway.route.OrderRoute;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean(name = "miniCamelContext")
    public CamelContext miniCamelContext() {

        DefaultCamelContext context = new DefaultCamelContext();

        context.addComponent("http", new HttpComponent());
        context.addComponent("kafka", new KafkaComponent());

        context.addRoute(
                "/orders",
                new OrderRoute(context).createRoute());

        context.start();

        return context;
    }
    @Bean
    public GatewayEngine gatewayEngine(
            @Qualifier("miniCamelContext")
            CamelContext camelContext) {

        return new GatewayEngine(camelContext);
    }
}
/**
@Configuration
public class GatewayConfiguration {

    @Bean
    public GatewayEngine gatewayEngine() {
        GatewayEngine engine = new GatewayEngine();
        engine.addRoute("/orders", new OrderRoute().createRoute());
        return engine;
    }
}
 */