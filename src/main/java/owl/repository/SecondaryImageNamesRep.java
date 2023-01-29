package owl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owl.models.SecondaryImageNames;


public interface SecondaryImageNamesRep extends JpaRepository<SecondaryImageNames, Long>{
    void deleteAllByProductForSaleId(Long id);
}
