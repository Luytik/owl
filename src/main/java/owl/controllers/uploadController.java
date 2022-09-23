package owl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/upload")
public class uploadController {

    private final String imageFolder = "./src/main/resources/static/assets/img/";

    @GetMapping
    public String uploadGoodsForm(){
        return "uploadGoods";
    }

    @PostMapping
    public String uploadGoodsToDB(Model model, @RequestParam("image")MultipartFile image, @RequestParam("name") String name) {

        try {
            uploadImageToFolder(image, name);
        } catch (IOException e) {
            e.printStackTrace();
        }


        model.addAttribute("msg", "Uploaded images: " + image.getOriginalFilename());
        return "uploadGoods";
    }

    private void uploadImageToFolder(MultipartFile image, String name) throws IOException{
        StringBuilder folderPath = new StringBuilder(imageFolder);
        folderPath.append(name);
        File folderForProductImage = new File(folderPath.toString());
        folderForProductImage.mkdir();
        Path pathToImage = Paths.get(folderForProductImage.toString(), image.getOriginalFilename());
        Files.write(pathToImage, image.getBytes());
    }
}
