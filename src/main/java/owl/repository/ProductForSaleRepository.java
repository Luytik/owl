package owl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owl.models.ProductForSale;

public interface ProductForSaleRepository extends JpaRepository<ProductForSale, Long> {
}
