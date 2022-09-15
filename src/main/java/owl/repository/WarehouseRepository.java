package owl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owl.models.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
