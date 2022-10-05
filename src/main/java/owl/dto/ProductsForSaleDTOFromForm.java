package owl.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import owl.models.ProductForSale;

import java.util.List;


@Data
@NoArgsConstructor
@ToString
public class ProductsForSaleDTOFromForm {
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
