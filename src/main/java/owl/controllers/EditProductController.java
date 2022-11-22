package owl.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import owl.dto.ProductsForSaleDTOFromForm;
import owl.models.Category;
import owl.models.ProductForSale;
import owl.repository.CategoryRepository;
import owl.repository.ProductForSaleRepository;
import owl.services.ProductForSaleService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EditProductController {

    private final ProductForSaleService productForSaleService;
    private final CategoryRepository categoryRepository;

    public EditProductController(ProductForSaleService productForSaleService, CategoryRepository categoryRepository) {
        this.productForSaleService = productForSaleService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/edit/{idProduct}")
    public String editProduct(@PathVariable("idProduct") long id) {
        return "editProduct";
    }

    //  "/edit/" + {idProduct}
    @PostMapping("/edit/{idProduct}")
    public String updateProduct(@PathVariable("idProduct") long id,
                                        @ModelAttribute ProductsForSaleDTOFromForm productsForSaleDTOfromForm){
        ProductForSale productForSale = productForSaleService.getProductById(id);
        productForSale.setName(productsForSaleDTOfromForm.getName());
        productForSale.setDescription(productsForSaleDTOfromForm.getDescription());
        productForSale.setPrice(productsForSaleDTOfromForm.getPrice());
        List<Category> categories = new ArrayList<>();
        if(productsForSaleDTOfromForm.getCategories() != null) {
            for (String categoryName : productsForSaleDTOfromForm.getCategories()) {
                Category category = categoryRepository.findCategoryByName(categoryName);
                categories.add(category);
            }
        }
        productForSale.setCategories(categories);
        productForSaleService.addProduct(productForSale);
        //return ResponseEntity.status(HttpStatus.OK).location(URI.create("/productList/")).build();
        return "redirect:/productList";
    }
}
