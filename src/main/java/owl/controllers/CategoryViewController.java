package owl.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/category")
public class CategoryViewController {

    @GetMapping("/{id}")
    public String viewProductsByCategory(@PathVariable ("id") long id){
            return "shop";
    }

}
