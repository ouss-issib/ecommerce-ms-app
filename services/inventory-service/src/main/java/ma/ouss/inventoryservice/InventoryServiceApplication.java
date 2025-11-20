package ma.ouss.inventoryservice;

import ma.ouss.inventoryservice.entities.Product;
import ma.ouss.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ProductRepository productRepository) {
        return args ->{
            productRepository.save(Product.builder().name("Pc").price(Math.random()*204).quantity(21).build());
            productRepository.save(Product.builder().name("Monitor").price(Math.random()*204).quantity(1).build());
            productRepository.save(Product.builder().name("Table").price(Math.random()*204).quantity(10).build());
        };
    }
}
