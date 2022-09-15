package owl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owl.models.Assembly;

public interface AssemblyRepository extends JpaRepository<Assembly, Long> {
}
