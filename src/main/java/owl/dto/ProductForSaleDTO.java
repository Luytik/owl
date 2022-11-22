package owl.dto;

import lombok.Data;
import owl.models.Category;
import owl.models.ProductForSale;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Data
public class ProductForSaleDTO {

    private Long id;
    private String name;
    private String description;
    private String price;
    private String cyrillicName;
    private List<String> categories;
    private List<String> imageNames = new ArrayList<>();

    public static ProductForSaleDTO of(ProductForSale productForSale){
        ProductForSaleDTO prDTO = new ProductForSaleDTO();
        prDTO.setId(productForSale.getId());
        prDTO.setName(productForSale.getName());
        prDTO.setDescription(productForSale.getDescription());
        prDTO.setPrice(productForSale.getPrice());
        prDTO.setCyrillicName(productForSale.getCyrillicName());
        prDTO.setImageNames();
        prDTO.setCategories(CategoriesDTO.asStringList(productForSale.getCategories()));
        return prDTO;
    }

    public void setImageNames(){
        String IMAGEFOLDER = "./src/main/upload/images/products/" + cyrillicName;
        File folder = new File(IMAGEFOLDER);
        for(File image : folder.listFiles()){
            imageNames.add(image.getName());
        }

    }
}
