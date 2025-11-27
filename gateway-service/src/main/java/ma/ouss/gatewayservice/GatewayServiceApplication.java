package ma.ouss.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    //Configuration dynamic of the gateway routes
    @Bean
    DiscoveryClientRouteDefinitionLocator locator(ReactiveDiscoveryClient rdc,
                                                  DiscoveryLocatorProperties dlp) {
//        dlp.setLowerCaseServiceId(true);
        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }
}


//Ou Bien Ajouter Un Bean de type RouteLocator ms c'est le meme il restera statiue
// @Bean
//    RouteLocator gatewayRoutes(RouteLocatorBuilder builder ) {
//        return builder.routes()
//                .route(r->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
//                .route(r->r.path("/products/**").uri("lb://INVENTORY-SERVICE/"))
//                .build();
//    }