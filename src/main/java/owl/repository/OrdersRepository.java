package owl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owl.models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
