package owl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import owl.models.ProductForSale;
import owl.repository.ProductForSaleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductForSaleService {
    private final ProductForSaleRepository productForSaleRepository;

    @Autowired
    public ProductForSaleService(ProductForSaleRepository productForSaleRepository) {
        this.productForSaleRepository = productForSaleRepository;
    }

    @Transactional
    public void addProduct(ProductForSale productForSale){
        productForSaleRepository.save(productForSale);
    }

    @Transactional
    public List<ProductForSale> getAllProducts(){
        return productForSaleRepository.findAll();
    }

    @Transactional
    public Optional<ProductForSale> getProductById(long id){
        return productForSaleRepository.findById(id);
    }
}
