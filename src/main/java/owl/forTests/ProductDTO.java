package owl.forTests;

import lombok.Data;
import lombok.NoArgsConstructor;
import owl.models.ProductForSale;

@Data
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String shortDescriprion;
    private String longDescriprion;
    private String price;
    private String mainPictureUrl;

    public ProductDTO(ProductForSale productForSale) {
        id = productForSale.getId();
        name = productForSale.getName();
        shortDescriprion = productForSale.getShortDescriprion();
        longDescriprion = productForSale.getLongDescriprion();
        price = productForSale.getPrice();
        mainPictureUrl = productForSale.getMainPictureUrl();

    }
    public static ProductDTO of(ProductForSale productForSale){
        return new ProductDTO(productForSale);
    }
}
