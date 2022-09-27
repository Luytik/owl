package owl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import owl.dto.ProductsForSaleDTO;
import owl.models.Category;
import owl.models.ProductForSale;
import owl.repository.CategoryRepository;
import owl.repository.ProductForSaleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductForSaleService {
    private final ProductForSaleRepository productForSaleRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductForSaleService(ProductForSaleRepository productForSaleRepository,
                                 CategoryRepository categoryRepository) {
        this.productForSaleRepository = productForSaleRepository;
        this.categoryRepository = categoryRepository;
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

    public ProductForSale convererFromDTO(ProductsForSaleDTO productsForSaleDTO){

        List<Category> categories = new ArrayList<>();

        for(String name: productsForSaleDTO.getCategories()){
            Category category = categoryRepository.findCategoryByName(name);
            categories.add(category);
        }

        ProductForSale productForSale = new ProductForSale();
        productForSale.setName(productsForSaleDTO.getName());
        productForSale.setShortDescriprion(productsForSaleDTO.getShortDescriprion());
        productForSale.setLongDescriprion(productsForSaleDTO.getLongDescriprion());
        productForSale.setPrice(productsForSaleDTO.getPrice());
        productForSale.setMainPictureUrl(productsForSaleDTO.getImage().getOriginalFilename());
        productForSale.setCategories(categories);

        return productForSale;
    }


}
