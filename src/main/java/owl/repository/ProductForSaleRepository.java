package owl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owl.models.ProductForSale;

import java.util.List;

public interface ProductForSaleRepository extends JpaRepository<ProductForSale, Long> {

    ProductForSale findTopByOrderByIdDesc();
    List<ProductForSale> findProductForSalesByCategoriesId(long id);

}
