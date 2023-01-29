package owl.restControllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.NoArgsConstructor;
import owl.dto.OrderFromFormDTO;
import owl.dto.ProductsInOrderDTO;
import owl.models.ProductsInOrder;
import owl.models.UserOrder;
import owl.services.OrderService;
import owl.services.ProductsInOrderService;

@RestController
@RequestMapping("/admin")
public class OrderRestController {

    private final OrderService orderService;
    private final ProductsInOrderService productsInOrderService;

    @Autowired
    public OrderRestController(OrderService orderService, ProductsInOrderService productsInOrderService){
        this.orderService = orderService;
        this.productsInOrderService = productsInOrderService;
    }

    @GetMapping("/getallorders")
    public List<OrderFromFormDTO> getAllOrders(){
        List<UserOrder> userOrderList = orderService.getAllOrders();
        List<OrderFromFormDTO> orderDtoList = new ArrayList<>();
        for(UserOrder uo : userOrderList){
            OrderFromFormDTO orderDto = new OrderFromFormDTO();
            orderDto.setFirstName(uo.getFirstName());
            orderDto.setSecondName(uo.getSecondName());
            orderDto.setTelNumber(uo.getTelNumber());
            orderDto.setDeliveryAddress(uo.getDeliveryAddress());
            orderDto.setDeliveryCompany(uo.getDeliveryCompany());
            orderDto.setDate(uo.getOrderDate().toString());
            orderDto.setId(uo.getId());
            orderDto.setStatus(uo.getStatus());
            orderDtoList.add(orderDto);
        }        
        return orderDtoList;
    }

    @GetMapping("/getproductsinorder/{id}")
    public List<ProductsInOrderDTO> getProductsInOrder(@PathVariable("id") Long orderId){
        List<ProductsInOrder> productsInCart = productsInOrderService.getProductsInCart(orderId);
        List<ProductsInOrderDTO> pDtoList = new ArrayList<>();
        for(ProductsInOrder pio : productsInCart){
            pDtoList.add(ProductsInOrderDTO.toDto(pio));
        }
        return pDtoList;
    }
}
