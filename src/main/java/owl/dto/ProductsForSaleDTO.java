package owl.dto;

import owl.models.Category;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

public class ProductsForSaleDTO {
    private String name;
    private String shortDescriprion;
    private String longDescriprion;
    private String price;
    private String mainPictureUrl;
    private List<String> categories;

    @Override
    public String toString() {
        return "ProductsForSaleDTO{" +
                "name='" + name + '\'' +
                ", shortDescriprion='" + shortDescriprion + '\'' +
                ", longDescriprion='" + longDescriprion + '\'' +
                ", price='" + price + '\'' +
                ", mainPictureUrl='" + mainPictureUrl + '\'' +
                ", categories=" + categories +
                '}';
    }
}
