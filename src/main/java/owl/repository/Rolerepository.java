package owl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import owl.models.Role;

@Repository
public interface Rolerepository extends JpaRepository<Role, Long> {
}
