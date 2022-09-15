package owl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owl.models.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
