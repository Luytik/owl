package owl.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ProductForSale {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String shortDescriprion;

    private String longDescriprion;
    @Column(nullable = false)
    private String price;

    private String mainPictureUrl;

    @ManyToMany
    @JoinTable(
            name = "productForSale_category",
            joinColumns = @JoinColumn(name = "productForSale_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
}
