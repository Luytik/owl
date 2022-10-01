package owl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import owl.dto.CategoriesDTO;
import owl.dto.CategoryDTO;
import owl.models.Category;
import owl.services.CategoryService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    private final String IMAGEFOLDER = "./src/main/upload/images/categories/";
    private final CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public String addNewCategory(@ModelAttribute CategoryDTO categoryDTO){
        Category category;
        category = CategoryDTO.of(categoryDTO);
        categoryService.addCategory(category);
        try {
            uploadImageToFolder(categoryDTO.getImage(), categoryDTO.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "addcategory";
    }

    @GetMapping("/addForm")
    public String getForm(){
        return "addcategory";
    }

    private void uploadImageToFolder(MultipartFile image, String name) throws IOException{
        StringBuilder folderPath = new StringBuilder(IMAGEFOLDER);
        folderPath.append(name);
        File folderForProductImage = new File(folderPath.toString());
        folderForProductImage.mkdir();
        Path pathToImage = Paths.get(folderForProductImage.toString(), image.getOriginalFilename());
        Files.write(pathToImage, image.getBytes());
    }

}
