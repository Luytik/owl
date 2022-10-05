package owl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import owl.models.Category;
import owl.models.ProductForSale;
import owl.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Transactional
    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    @Transactional
    public void findByName(String name){
        categoryRepository.findCategoryByName(name);
    }
}

