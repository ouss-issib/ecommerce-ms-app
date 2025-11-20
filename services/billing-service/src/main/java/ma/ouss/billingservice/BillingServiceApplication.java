package ma.ouss.billingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;
import ma.ouss.billingservice.entities.Bill;
import ma.ouss.billingservice.entities.Customer;
import ma.ouss.billingservice.entities.Product;
import ma.ouss.billingservice.entities.ProductItem;
import ma.ouss.billingservice.feign.CustomerRestClient;
import ma.ouss.billingservice.feign.ProductRestClient;
import ma.ouss.billingservice.repositories.BillRepository;
import ma.ouss.billingservice.repositories.ProductItemRepository;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {

        return args -> {

            Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
            Collection<Product> products = productRestClient.getAllProducts().getContent();

            customers.forEach(customer -> {
                System.out.println(customer.toString());
                Bill bill = Bill.builder()
                        .billingDate(new Date())
                        .customerId(customer.getId())
                        .build();
                billRepository.save(bill);

                products.forEach(product -> {
                    ProductItem productItem  = ProductItem.builder()
                            .id(new Random().nextLong())
                            .bill(bill)
                            .productId(product.getId())
                            .quantity(new Random().nextInt(10) + 1)
                            .unitPrice(product.getPrice())
                            .build();
                    productItemRepository.save(productItem);
                });
            });
        };
    }
}
