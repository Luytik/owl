package owl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import owl.models.ProductsInOrder;

@Repository
public interface ProductsInOrderRep extends JpaRepository<ProductsInOrder, Long>{
    List<ProductsInOrder> findProductInOrdersByOrderId(Long id);
}
