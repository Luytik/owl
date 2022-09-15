package owl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owl.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
