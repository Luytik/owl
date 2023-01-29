package owl.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import owl.models.ProductsInOrder;
import owl.models.Status;
import owl.models.User;

@Data
@NoArgsConstructor
public class OrderFromFormDTO {    
    private String firstName;
    private String secondName;
    private String telNumber;
    private String deliveryAddress;
    private String deliveryCompany;
    private String date;
    private Long id;
    private Status status;
}
