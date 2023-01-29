package owl.dto;

import lombok.Data;
import owl.models.Category;
import owl.models.ProductForSale;
import owl.models.SecondaryImageNames;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;


@Data
public class ProductForSaleDTO {

    private Long id;
    private String name;
    private String description;
    private String price;
    private String cyrillicName;
    private String mainImageName;
    private List<String> categories;
    private List<String> imageNames = new ArrayList<>();

    public static ProductForSaleDTO of(ProductForSale productForSale){
        ProductForSaleDTO prDTO = new ProductForSaleDTO();
        prDTO.setId(productForSale.getId());
        prDTO.setName(productForSale.getName());
        prDTO.setDescription(productForSale.getDescription());
        prDTO.setPrice(productForSale.getPrice());
        prDTO.setCyrillicName(productForSale.getCyrillicName());
        prDTO.setMainImageName(productForSale.getMainImageName());
        prDTO.setImageNamesAsString(productForSale);
        prDTO.setCategories(CategoriesDTO.asStringList(productForSale.getCategories()));
        return prDTO;
    }

    private void setImageNamesAsString(ProductForSale productForSale){
        for(SecondaryImageNames s : productForSale.getSecondaryImageNames()){
            imageNames.add(s.getName());
        }
    }
}
