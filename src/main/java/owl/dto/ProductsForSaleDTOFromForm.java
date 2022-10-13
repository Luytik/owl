package owl.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import owl.models.Category;
import owl.models.ProductForSale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Data
@NoArgsConstructor
public class ProductsForSaleDTOFromForm {
    private String name;
    private String descriprion;
    private String price;
    private List<String> categories;
    private MultipartFile mainImage;
    private MultipartFile[] additionalImages;


    @Override
    public String toString() {
        return "ProductsForSaleDTOFromForm{" +
                "name='" + name + '\'' +
                ", descriprion='" + descriprion + '\'' +
                ", price='" + price + '\'' +
                ", categories=" + categories +
                ", mainImage=" + mainImage.getOriginalFilename() +
                ", additionalImages=" + Arrays.toString(additionalImages) +
                '}';
    }


}
