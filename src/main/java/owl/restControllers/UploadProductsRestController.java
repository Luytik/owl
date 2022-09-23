package owl.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import owl.dto.CategoriesDTO;
import owl.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class UploadProductsRestController {

    private final CategoryService categoryService;

    @Autowired
    public UploadProductsRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public CategoriesDTO getCategories(){
        return CategoriesDTO.of(categoryService.getAllCategories());
    }
}
