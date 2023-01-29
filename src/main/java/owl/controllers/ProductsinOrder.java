package owl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/productsinorder")
public class ProductsinOrder {

    @GetMapping("/{id}")
    public String viewAdminPanel(@PathVariable Long id){
        return "productsinorder.html";
    }
}
