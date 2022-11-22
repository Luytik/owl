package owl.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import owl.dto.ProductForSaleDTO;
import owl.dto.ProductsForSaleDTOFromForm;
import owl.dto.QuantityDTO;
import owl.models.Category;
import owl.models.ProductForSale;
import owl.repository.CategoryRepository;
import owl.services.CategoryService;
import owl.services.ProductForSaleService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsRestController {

    private final ProductForSaleService productForSaleService;
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;
    static final int ITEMS_PER_PAGE = 9;

    @Autowired
    public ProductsRestController(ProductForSaleService productForSaleService, CategoryRepository categoryRepository, CategoryService categoryService) {
        this.productForSaleService = productForSaleService;
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @GetMapping("/getLastThreeProducts")
    public List<ProductForSaleDTO> getLastThreeProducts() {
        return productForSaleService.getLastThreeProducts();
    }

    // "/products/deleteProduct/{id}"
    @GetMapping("/deleteProduct/{id}")
    public void deleteSMT(@PathVariable("id")long id) {
        productForSaleService.deleteProduct(id);
    }

    //  /products/all
    @GetMapping("/all")
    public List<ProductForSaleDTO> getAllProducts(@RequestParam(required = false,
            defaultValue = "0") Integer page) {
        List<ProductForSaleDTO> productForSaleDTOList = new ArrayList<>();
        List<ProductForSale> productForSales = productForSaleService.getAllProducts(PageRequest.of(page,
                ITEMS_PER_PAGE,
                Sort.Direction.ASC, "id"));
        for (ProductForSale pfs : productForSales) {
            productForSaleDTOList.add(ProductForSaleDTO.of(pfs));
        }
        return productForSaleDTOList;
    }


    @GetMapping("/category/{id}")
    public List<ProductForSaleDTO> getProductsByCategory(@PathVariable("id") long categoryId,
                                              @RequestParam(required = false, defaultValue = "0") Integer page) {
        List<ProductForSaleDTO> productForSaleDTOList = new ArrayList<>();
        List<ProductForSale> productForSalelist = productForSaleService.getAllProductsByCategoryId(categoryId,
                PageRequest.of(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (ProductForSale pfs : productForSalelist) {
            productForSaleDTOList.add(ProductForSaleDTO.of(pfs));
        }
        return productForSaleDTOList;
    }

    @GetMapping("/{id}")
    public ProductForSaleDTO getProductById(@PathVariable("id") long id) {
        return productForSaleService.getProductDTOById(id);
    }

    @GetMapping(value = "/count")
    public QuantityDTO count (){
        return productForSaleService.countProducts();
    }

    @GetMapping(value = "/countByCategory/{id}")
    public QuantityDTO countByCategory(@PathVariable("id") long id){
        QuantityDTO q = productForSaleService.countByCategory(id);
        return q;
    }
}
