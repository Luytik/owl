package owl.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import owl.models.Category;

@Data
@NoArgsConstructor
@ToString
public class CategoryDtoFromForm {
    private String name;
    private MultipartFile image;

    public static Category of(CategoryDtoFromForm categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setImage(categoryDTO.getImage().getOriginalFilename());
        return category;
    }
}
