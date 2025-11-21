package ma.ouss.customerservice;

import ma.ouss.customerservice.Repositories.CustomerRepository;
import ma.ouss.customerservice.config.CustomerConfigParams;
import ma.ouss.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return args ->{
            customerRepository.save(Customer.builder().name("nizar").email("nizar@gmail.com").build());
            customerRepository.save(Customer.builder().name("jamila").email("jamila@gmail.com").build());
            customerRepository.save(Customer.builder().name("zouita").email("zouita@gmail.com").build());
        };
    }
}
