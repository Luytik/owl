package owl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import owl.dto.CategoriesDTO;

@Controller
@RequestMapping("/categories/add")
public class CategoriesController {

    @PostMapping
    public void addNewCategory(@ModelAttribute CategoriesDTO categoriesDTO){

    }
}
