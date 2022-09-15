package owl.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
public class Purchases {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private Double totalPrice;
    @Column(nullable = false)
    private Double SelfPrice;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private MeasurementUnit measurementUnit;
}
