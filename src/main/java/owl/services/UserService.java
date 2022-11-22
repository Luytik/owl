package owl.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import owl.models.User;
import owl.models.UserRole;
import owl.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional
    public boolean addUser(String username, String password, String email) {
        if (userRepository.existsByUsername(username))
            return false;
        User user = new User(username, email, password);
        userRepository.save(user);
        return true;
    }
}
