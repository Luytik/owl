package owl.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Supplier {
    @Id
    private Long id;

    private String name;
    private String phone;
    @Column(unique = true)
    private String email;
    private String country;
    private String city;

    @ManyToMany
    @JoinTable(
            name = "suppliers_goods",
            joinColumns = @JoinColumn(name = "supplier_id"),
            inverseJoinColumns = @JoinColumn(name = "goods_id")
    )
    private List<Goods> goodsList;
}
