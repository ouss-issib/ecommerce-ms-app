package ma.ouss.billingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.ouss.billingservice.entities.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
