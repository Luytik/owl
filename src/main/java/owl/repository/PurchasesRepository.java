package owl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owl.models.Purchases;

public interface PurchasesRepository extends JpaRepository<Purchases, Long> {
}
