package owl.restControllers;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/profile/cart")
public class Cart {

    @GetMapping("/addtocart/{id}")
    public String addToCart(@PathVariable("id") Long productId, Principal principal){
        return "from Spring sec: " + principal.getName();
    }
}
