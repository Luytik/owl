package owl.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<ProductsInOrder> productsInOrderList = new ArrayList<>();

    @ManyToOne
    @JoinTable(name = "shopper_id")
    private User user;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private String deliveryAddress;

    private String name;
    private String surname;

    private String telephone;

    private String deliveryService;
    private Double summa;
}
