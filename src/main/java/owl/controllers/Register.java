package owl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Register {
    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }
    
}
