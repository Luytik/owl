package owl.models;

import lombok.*;
import owl.services.FromCyrillicToLatin;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class ProductForSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String cyrillicName;

    private String price;

    private String mainImageName;

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

    @OneToMany(mappedBy = "productForSale", cascade = CascadeType.ALL)
    private List<ProductsInOrder> productsList = new ArrayList<>();

    @OneToMany(mappedBy = "productForSale", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SecondaryImageNames> secondaryImageNames = new ArrayList<>();

    public ProductForSale(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
