package owl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile/cart")
public class CartController {
    
    @GetMapping
    public String viewCart(){
        return "cart.html";
    }
}
