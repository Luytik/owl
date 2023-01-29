package owl.restControllers;

import org.springframework.web.bind.annotation.*;

import owl.dto.OrderFromFormDTO;
import owl.dto.ProductsInOrderDTO;
import owl.models.ProductForSale;
import owl.models.ProductsInOrder;
import owl.models.Status;
import owl.services.ProductForSaleService;
import owl.services.ProductsInOrderService;
import owl.services.OrderService;
import owl.services.UserService;
import owl.models.User;
import owl.models.UserOrder;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/profile/cart")
public class CartRestController {

    private final ProductForSaleService productForSaleService;
    private final OrderService orderService;
    private final UserService userService;
    private final ProductsInOrderService productsInOrderService;

    public CartRestController(ProductForSaleService productForSaleService, OrderService orderService, 
                                UserService userService, ProductsInOrderService productsInOrderervice){
        this.productForSaleService = productForSaleService;
        this.orderService = orderService;
        this.userService = userService;
        this.productsInOrderService = productsInOrderervice;
    }

    @GetMapping("/addtocart/{id}")
    public void addToCart(@PathVariable("id") Long productId, Principal principal,
                                HttpServletResponse response ,@RequestParam(defaultValue = "1") Integer quantity)
                                throws IOException{
        ProductForSale productForSale = productForSaleService.getProductById(productId);
        User user = userService.findByUsername(principal.getName());
        UserOrder order;
        long openedOrderId = orderService.findOpenedOrder(user.getId());
        if(openedOrderId >= 0 ){
            order = orderService.findUserOrderById(openedOrderId);
            ProductsInOrder productsInOrder = new ProductsInOrder();
            productsInOrder.setOrder(order);
            productsInOrder.setProductForSale(productForSale);
            productsInOrder.setQuantity(quantity);
            productsInOrder.setPricePerProduct(productForSale.getPrice());
            productsInOrderService.addProductToOrder(productsInOrder);
        } else {
            order = new UserOrder();
            order.setUser(user); 
            order.setStatus(Status.CART);
            orderService.addOrder(order);
            ProductsInOrder productsInOrder = new ProductsInOrder();
            productsInOrder.setOrder(order);
            productsInOrder.setProductForSale(productForSale);
            productsInOrder.setQuantity(quantity);
            productsInOrder.setPricePerProduct(productForSale.getPrice());
            productsInOrderService.addProductToOrder(productsInOrder);
        }
        response.sendRedirect("/shop");
    }

    @GetMapping("/getproductsincart")
    public List<ProductsInOrderDTO> getProductsInCart(Principal principal){
        User user = userService.findByUsername(principal.getName());
        long openedOrderId = orderService.findOpenedOrder(user.getId());
        List<ProductsInOrder> productsInCart = productsInOrderService.getProductsInCart(openedOrderId);
        List<ProductsInOrderDTO> pDtoList = new ArrayList<>();
        for(ProductsInOrder pio : productsInCart){
            pDtoList.add(ProductsInOrderDTO.toDto(pio));
        }
        return pDtoList;
    }
    
    @PostMapping("/orderprocessing")
    public void orderProcessing(@ModelAttribute OrderFromFormDTO orderFromFormDTO, Principal principal, 
                                HttpServletResponse response) throws IOException{
        User user = userService.findByUsername(principal.getName());
        long openedOrderId = orderService.findOpenedOrder(user.getId());
        UserOrder order = orderService.findUserOrderById(openedOrderId);
        order.setFirstName(orderFromFormDTO.getFirstName());
        order.setSecondName(orderFromFormDTO.getSecondName());
        order.setDeliveryAddress(orderFromFormDTO.getDeliveryAddress());
        order.setDeliveryCompany(orderFromFormDTO.getDeliveryCompany());
        order.setTelNumber(orderFromFormDTO.getTelNumber());
        orderService.changeStatusInOrder(Status.IN_REQUEST, order);
        response.sendRedirect("/index");        
    }

    @GetMapping("/deleteproductfromcart/{id}")
    public void deleteproductfromcart(@PathVariable("id") Long productId, HttpServletResponse response) throws IOException{
        productsInOrderService.deleteproductfromcart(productId);
        response.sendRedirect("/profile/cart");
    }
}

