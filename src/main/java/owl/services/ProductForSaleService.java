package owl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import owl.dto.ProductForSaleDTO;
import owl.dto.ProductsForSaleDTOFromForm;
import owl.dto.QuantityDTO;
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
    public List<ProductForSale> getAllProducts(Pageable pageable){
        return productForSaleRepository.findAll(pageable).getContent();
    }

    @Transactional
    public ProductForSaleDTO getProductById(long id){
        return ProductForSaleDTO.of(productForSaleRepository.findById(id).get());
    }

    @Transactional
    public List<ProductForSaleDTO> getLastThreeProducts(){
        List<ProductForSaleDTO> lastThreeProducts = new ArrayList<>();
        ProductForSaleDTO last = new ProductForSaleDTO();
        last = ProductForSaleDTO.of(productForSaleRepository.findTopByOrderByIdDesc());
        long id = last.getId();
        ProductForSaleDTO preLast = ProductForSaleDTO.of(productForSaleRepository.findById( id - 1).get());
        ProductForSaleDTO prePreLast = ProductForSaleDTO.of(productForSaleRepository.findById( id - 2).get());
        lastThreeProducts.add(prePreLast);
        lastThreeProducts.add(preLast);
        lastThreeProducts.add(last);

        return lastThreeProducts;
    }

    @Transactional
    public void deleteProduct(long id){
        productForSaleRepository.deleteById(id);
    }

    public ProductForSale convererFromDTO(ProductsForSaleDTOFromForm productsForSaleDTO){

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

    @Transactional
    public List<ProductForSale> getAllProductsByCategoryId(long categoryId, Pageable pageable){
       return productForSaleRepository.findProductForSalesByCategoriesId(categoryId, pageable);
    }

    @Transactional
    public QuantityDTO countProducts(){
        return QuantityDTO.of(productForSaleRepository.count());
    }
}
