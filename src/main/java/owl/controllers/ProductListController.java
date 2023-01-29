package owl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/productList")
public class ProductListController {

    @GetMapping
    public String productlist(){
        return "productList";
    }
}
