package owl.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import owl.models.ProductsInOrder;
import owl.repository.ProductsInOrderRep;

@Service
public class ProductsInOrderService {
    private final ProductsInOrderRep productsInOrderRep;

    @Autowired
    public ProductsInOrderService(ProductsInOrderRep productsInOrderRep){
        this.productsInOrderRep = productsInOrderRep;
    }

    @Transactional
    public void addProductToOrder(ProductsInOrder productsInOrder){
        productsInOrderRep.save(productsInOrder);
    }

    @Transactional
    public List<ProductsInOrder> getProductsInCart(Long id){
        return productsInOrderRep.findProductInOrdersByOrderId(id);
    }

    @Transactional
    public void deleteproductfromcart(Long id){
        productsInOrderRep.deleteById(id);
    }
}
