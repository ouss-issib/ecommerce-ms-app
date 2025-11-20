package ma.ouss.billingservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ma.ouss.billingservice.entities.Bill;
import ma.ouss.billingservice.feign.CustomerRestClient;
import ma.ouss.billingservice.feign.ProductRestClient;
import ma.ouss.billingservice.repositories.BillRepository;
import ma.ouss.billingservice.repositories.ProductItemRepository;

@RestController
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productRepository;
    private ProductRestClient productRestClient;
    private CustomerRestClient customerRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productRepository
            , ProductRestClient productRestClient, CustomerRestClient customerRestClient) {
        this.billRepository = billRepository;
        this.productRepository = productRepository;
        this.productRestClient = productRestClient;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/bills/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill;
        bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });
        return bill;
    }
}
