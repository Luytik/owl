package owl.forTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import owl.models.ProductForSale;
import owl.services.ProductForSaleService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/testProduct")
public class TestProductHTML {
    private final ProductForSaleService productForSaleService;

    @Autowired
    public TestProductHTML(ProductForSaleService productForSaleService) {
        this.productForSaleService = productForSaleService;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts(){
        List<ProductForSale> productForSaleList = productForSaleService.getAllProducts();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(ProductForSale pfs: productForSaleList){
            productDTOList.add(ProductDTO.of(pfs));
        }
        return productDTOList;
    }
}
