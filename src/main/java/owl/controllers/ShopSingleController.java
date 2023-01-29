package owl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/shop-single/{id}")
public class ShopSingleController {

    @GetMapping
    public String getShopPage(@PathVariable("id") long id){
        return "shop-single";
    }
}
