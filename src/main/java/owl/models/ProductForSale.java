package owl.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import owl.services.FromCyrillicToLatin;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductForSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String cyrillicName;

    private String price;

    @ManyToMany()
    @JoinTable(
            name = "productForSale_category",
            joinColumns = @JoinColumn(name = "productForSale_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    public void setCyrillicName(){
        this.cyrillicName = FromCyrillicToLatin.transliterate(name);
    }

    public ProductForSale(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
