package owl.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import owl.dto.ProductForSaleDTO;
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

    @Autowired
    public ProductsRestController(ProductForSaleService productForSaleService, CategoryService categoryService) {
        this.productForSaleService = productForSaleService;
        this.categoryService = categoryService;
    }

    @GetMapping("/getLastThreeProducts")
    public List<ProductForSaleDTO> getLastThreeProducts(){
        return productForSaleService.getLastThreeProducts();
    }

    @GetMapping("/delete")
    public void deleteSMT(){
        productForSaleService.deleteProduct(31l);
    }

    @GetMapping("/all")
    public List<ProductForSaleDTO> getAllProducts(){
        List<ProductForSaleDTO> productForSaleDTOList = new ArrayList<>();
        List<ProductForSale> productForSales = productForSaleService.getAllProducts();
        for(ProductForSale pfs : productForSales){
            productForSaleDTOList.add(ProductForSaleDTO.of(pfs));
        }
        return productForSaleDTOList;
    }


    @GetMapping("/category/{id}")
    public List<ProductForSaleDTO> getProductsByCategory(@PathVariable("id") long categoryId){
        List<ProductForSaleDTO> productForSaleDTOList = new ArrayList<>();
        List<ProductForSale> productForSalelist = productForSaleService.getAllProductsByCategoryId(categoryId);
        for(ProductForSale pfs : productForSalelist){
            productForSaleDTOList.add(ProductForSaleDTO.of(pfs));
        }
        return productForSaleDTOList;
    }

    @GetMapping("/{id}")
    public ProductForSaleDTO getProductById(@PathVariable("id") long id){
        return productForSaleService.getProductById(id);
    }
}
