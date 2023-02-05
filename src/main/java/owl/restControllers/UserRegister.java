package owl.restControllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import owl.models.User;
import owl.models.Role;
import owl.services.RoleService;
import owl.services.UserService;

@RestController
public class UserRegister {

    private final RoleService roleService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserRegister(RoleService roleService, UserService userService, PasswordEncoder passwordEncoder){
        this.roleService = roleService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/newUser")
    public void addNewUser(@ModelAttribute User user, HttpServletResponse response) throws IOException{
        Role role = roleService.findByName("user");
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userService.addUser(user);
        response.sendRedirect("/index");

    }
}
