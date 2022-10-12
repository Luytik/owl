package owl.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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

    @Column(nullable = false, unique = true)
    private String name;

    private String descriprion;
    @Column(nullable = false)
    private String price;

    private String mainPictureUrl;

    @ManyToMany()
    @JoinTable(
            name = "productForSale_category",
            joinColumns = @JoinColumn(name = "productForSale_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;



    public ProductForSale(String name, String shortDescriprion, String longDescriprion, String price, String mainPictureUrl) {
        this.name = name;
        this.descriprion = longDescriprion;
        this.price = price;
        this.mainPictureUrl = mainPictureUrl;
    }
}
