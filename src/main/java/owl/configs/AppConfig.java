package owl.configs;

import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import owl.services.RoleService;
import owl.services.UserService;
import owl.models.Role;
import owl.models.User;
import java.util.ArrayList;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppConfig extends GlobalMethodSecurityConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**", "/css/**", "/js/**")
                .addResourceLocations("file:///" + System.getProperty("user.dir") + "/src/main/upload/",
                        "classpath:/static/assets/css/", "classpath:/static/assets/js/");
    }

    @Bean 
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner runner (final UserService userService,
                                     final RoleService roleService,
                                     final PasswordEncoder encoder){
        return new CommandLineRunner() {
            @Override
            public void run(String...strings) throws Exception{
                //Adding user role
                Role role_user = new Role("ROLE_USER");
                roleService.addRole(role_user);
                //Adding admin role
                Role role_admin = new Role("ROLE_ADMIN");
                roleService.addRole(role_admin);
                //Adding user - admin
                User admin = new User();
                admin.setUsername("admin");
                admin.setEmail("superAdminEmail");
                admin.setPassword(encoder.encode("100"));
                ArrayList<Role> aRoles = new ArrayList<>();
                aRoles.add(role_admin);
                admin.setRoles(aRoles);
                userService.addUser(admin);
                //
                User user = new User();
                user.setUsername("user");
                user.setEmail("superUserEmail");
                user.setPassword(encoder.encode("100"));
                ArrayList<Role> uRoles = new ArrayList<>();
                uRoles.add(role_user);
                user.setRoles(uRoles);
                userService.addUser(user);
            }
        };

    }
}
