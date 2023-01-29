package owl.dto;

import lombok.Data;
import owl.models.ProductForSale;
import owl.models.ProductsInOrder;
import owl.models.UserOrder;

@Data
public class ProductsInOrderDTO {
    
    private Long id;
    private Integer quantity;
    private ProductForSaleDTO productForSaleDTO;
    private String pricePerProduct;

    public static ProductsInOrderDTO toDto(ProductsInOrder productsInOrder){
        ProductsInOrderDTO pDto = new ProductsInOrderDTO();
        pDto.setId(productsInOrder.getId());
        pDto.setQuantity(productsInOrder.getQuantity());
        pDto.setProductForSaleDTO(ProductForSaleDTO.of(productsInOrder.getProductForSale()));
        pDto.setId(productsInOrder.getId());
        return pDto;
    }
}
