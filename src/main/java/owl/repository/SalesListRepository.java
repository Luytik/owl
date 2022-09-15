package owl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owl.models.SalesList;

public interface SalesListRepository extends JpaRepository<SalesList, Long> {
}
