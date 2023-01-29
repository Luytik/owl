package owl.models;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "UserOrder_id")
    private User user;
    private String firstName;
    private String secondName;
    @Enumerated(EnumType.STRING)
    private Status status;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date orderDate;
    private String deliveryAddress;
    private String telNumber;
    private String deliveryCompany;
    @OneToMany(cascade = CascadeType.ALL)
    List<ProductsInOrder> productsInOrder = new ArrayList<>();
}
