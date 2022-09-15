package owl.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
public class Orders {
    public enum IsDone{
        YES,NO
    }

    @Id
    private Long id;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private Double totalPrice;
    private Double selfPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Enumerated(EnumType.STRING)
    private IsDone isDone;

    @ManyToOne
    @JoinColumn(name = "salesList_id")
    private SalesList salesList;
}
