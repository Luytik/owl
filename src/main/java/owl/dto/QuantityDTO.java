package owl.dto;

import lombok.Data;

@Data
public class QuantityDTO {
    private long quantity;

    public QuantityDTO(long quantity){
        this.quantity = quantity;
    }

    public static QuantityDTO of(long q){
        return new QuantityDTO(q);
    }

}
