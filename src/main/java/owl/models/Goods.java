package owl.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Goods {
    public enum Status {
        MAKE, BUY
    }

    public Goods() {
    }

    public Goods(String name, Status status, MeasurementUnit measurementUnit, IsStoredOnWarehouse isStoredOnWarehouse) {
        this.name = name;
        this.status = status;
        this.measurementUnit = measurementUnit;
        this.isStoredOnWarehouse = isStoredOnWarehouse;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated (EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private MeasurementUnit measurementUnit;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IsStoredOnWarehouse isStoredOnWarehouse;

    @OneToOne(mappedBy = "goods")
    private Warehouse amountOfGoodsAtWarehouse;

    @OneToMany(mappedBy = "goods", fetch = FetchType.LAZY)
    private List<Assembly> assembly;

    @OneToOne(mappedBy = "goods")
    private SalesList salesList;

    @OneToMany(mappedBy = "goods")
    private List<Purchases> purchases;

    @ManyToMany
    @JoinTable(
            name = "suppliers_goods",
            joinColumns = @JoinColumn(name = "goods_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private List<Supplier> supplierList;


    @Transient
    private double selfPrice;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public IsStoredOnWarehouse getIsStoredOnWarehouse() {
        return isStoredOnWarehouse;
    }

    public void setIsStoredOnWarehouse(IsStoredOnWarehouse isStoredOnWarehouse) {
        this.isStoredOnWarehouse = isStoredOnWarehouse;
    }

    public double getSelfPrice() {
        return selfPrice;
    }

    public void setSelfPrice(double selfPrice) {
        this.selfPrice = selfPrice;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", measurementUnit=" + measurementUnit +
                ", isStoredOnWarehouse=" + isStoredOnWarehouse +
                ", selfPrice=" + selfPrice +
                '}';
    }
}
