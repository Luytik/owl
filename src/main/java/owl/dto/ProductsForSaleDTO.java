package owl.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import owl.models.Category;
import owl.models.ProductForSale;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;


@Data
@NoArgsConstructor
@ToString
public class ProductsForSaleDTO {
    private String name;
    private String shortDescriprion;
    private String longDescriprion;
    private String price;
    private MultipartFile image;
    private List<String> categories;

    public static ProductForSale of(){
        return new ProductForSale();
    }


}
