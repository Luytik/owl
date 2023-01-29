package owl.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class ProductsInOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserOrder_id")
    private UserOrder order;

    @ManyToOne
    @JoinColumn(name = "productForSale_id")
    private ProductForSale productForSale;

    private Integer quantity;
    private String pricePerProduct;
}
