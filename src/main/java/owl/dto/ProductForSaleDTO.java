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
    private String shortDescriprion;
    private String longDescriprion;
    private String price;
    private String mainPictureUrl;
    private List<String> categories;

    public static ProductForSaleDTO of(ProductForSale productForSale){
        ProductForSaleDTO prDTO = new ProductForSaleDTO();
        prDTO.setId(productForSale.getId());
        prDTO.setName(productForSale.getName());
        prDTO.setShortDescriprion(productForSale.getShortDescriprion());
        prDTO.setLongDescriprion(productForSale.getLongDescriprion());
        prDTO.setPrice(productForSale.getPrice());
        prDTO.setMainPictureUrl(productForSale.getMainPictureUrl());
        prDTO.setCategories(CategoriesDTO.asStringList(productForSale.getCategories()));
        return prDTO;
    }
}
