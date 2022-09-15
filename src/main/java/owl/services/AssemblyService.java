package owl.services;

import org.springframework.stereotype.Service;
import owl.repository.AssemblyRepository;

@Service
public class AssemblyService {

    private final AssemblyRepository assemblyRepository;

    public AssemblyService(AssemblyRepository assemblyRepository) {
        this.assemblyRepository = assemblyRepository;
    }
}
