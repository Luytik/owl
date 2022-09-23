package owl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owl.repository.ProductForSaleRepository;

@Service
public class ProductForSaleService {
    private final ProductForSaleRepository productForSaleRepository;

    @Autowired
    public ProductForSaleService(ProductForSaleRepository productForSaleRepository) {
        this.productForSaleRepository = productForSaleRepository;
    }
}
