package owl.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import owl.repository.Rolerepository;
import owl.models.Role;

@Service
public class RoleService {
    private final Rolerepository roleRepository;
    
    public RoleService(Rolerepository rolerepository){
        this.roleRepository = rolerepository;
    }

    @Transactional
    public void addRole(Role role){
        roleRepository.save(role);
    }

    @Transactional
    public Role findByName(String name){
        return roleRepository.findByName(name);
    }
}
