package owl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile/cart/placingorder")
public class PlaceOrderontroller {
    @GetMapping
    public String placeOrder(){
        return "order.html";
    }
}
