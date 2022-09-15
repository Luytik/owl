package owl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owl.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
