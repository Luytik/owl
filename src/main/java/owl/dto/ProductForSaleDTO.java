package owl.dto;

import lombok.Data;
import owl.models.Category;
import owl.models.ProductForSale;

import java.util.ArrayList;
import java.util.List;


@Data
public class ProductForSaleDTO {

    private Long id;
    private String name;
    private String description;
    private String price;
    private List<String> categories;

    public static ProductForSaleDTO of(ProductForSale productForSale){
        ProductForSaleDTO prDTO = new ProductForSaleDTO();
        prDTO.setId(productForSale.getId());
        prDTO.setName(productForSale.getName());
        prDTO.setDescription(productForSale.getDescription());
        prDTO.setPrice(productForSale.getPrice());
        prDTO.setCategories(CategoriesDTO.asStringList(productForSale.getCategories()));
        return prDTO;
    }
}
