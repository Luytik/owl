package owl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owl.models.Category;
import owl.models.ProductForSale;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String name);
}
