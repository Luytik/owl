package owl.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import owl.dto.CategoriesDTO;
import owl.dto.CategoryDTO;
import owl.models.Category;
import owl.services.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesRestController {

    private final CategoryService categoryService;

    @Autowired
    public CategoriesRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAllCategoriesAsStringArray")
    public List<String> getAllCategories() {
        return CategoriesDTO.asStringList(categoryService.getAllCategories());
    }

    @GetMapping("/getAllCategories")
    public List<CategoryDTO> listCategory() {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        for(Category c: categoryService.getAllCategories()){
            categoryDTOList.add(CategoryDTO.of(c));
        }
        return categoryDTOList;
    }
}
