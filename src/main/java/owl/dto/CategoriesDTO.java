package owl.dto;

import lombok.Data;
import owl.models.Category;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoriesDTO {
    private final List<String> categories;

    public CategoriesDTO(List<String> categories) {
        this.categories = categories;
    }

    public static List<String> of(List<Category> categories){
        List<String> categoryNames = new ArrayList<>();
        for(Category c: categories){
            categoryNames.add(c.getName());
        }
        return categoryNames;
    }
}
