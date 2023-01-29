package owl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import owl.models.UserOrder;

@Repository
public interface OrderRepository extends JpaRepository<UserOrder, Long>{
    List<UserOrder> findAllByUserId(long id);
    UserOrder findUserOrderById(long id);
}
