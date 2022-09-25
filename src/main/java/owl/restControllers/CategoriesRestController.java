package owl.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import owl.dto.CategoriesDTO;
import owl.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/getAllCategories")
public class CategoriesRestController {

    private final CategoryService categoryService;

    @Autowired
    public CategoriesRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<String> getAllCategories(){
        return CategoriesDTO.of(categoryService.getAllCategories());
    }
}
