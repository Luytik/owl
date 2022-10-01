package owl.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import owl.models.Category;

@Data
@NoArgsConstructor
@ToString
public class CategoryDTO {
    private String name;
    private MultipartFile image;

    public static Category of(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setImage(categoryDTO.getImage().getOriginalFilename());
        return category;
    }
}
