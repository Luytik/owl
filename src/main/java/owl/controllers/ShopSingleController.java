package owl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/shop-single")
public class ShopSingleController {
    @GetMapping
    public String getShopPage(){
        return "shop-single";
    }
}
