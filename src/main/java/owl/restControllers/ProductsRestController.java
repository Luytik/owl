package owl.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import owl.dto.ProductForSaleDTO;
import owl.dto.QuantityDTO;
import owl.models.ProductForSale;
import owl.services.CategoryService;
import owl.services.ProductForSaleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsRestController {

    private final ProductForSaleService productForSaleService;
    private final CategoryService categoryService;
    static final int ITEMS_PER_PAGE = 9;

    @Autowired
    public ProductsRestController(ProductForSaleService productForSaleService, CategoryService categoryService) {
        this.productForSaleService = productForSaleService;
        this.categoryService = categoryService;
    }

    @GetMapping("/getLastThreeProducts")
    public List<ProductForSaleDTO> getLastThreeProducts() {
        return productForSaleService.getLastThreeProducts();
    }

    @GetMapping("/delete")
    public void deleteSMT() {
        productForSaleService.deleteProduct(31l);
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
        return productForSaleService.getProductById(id);
    }

    @GetMapping(value = "/count")
    public QuantityDTO count (){
        return productForSaleService.countProducts();
    }
}
