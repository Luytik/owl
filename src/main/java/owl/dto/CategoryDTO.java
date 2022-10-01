package owl.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import owl.models.Category;

import java.util.List;

@Data
public class CategoryDTO {

    private Long id;
    private String name;
    private String image;

    public static CategoryDTO of(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setImage(category.getImage());
        return categoryDTO;
    }
}
