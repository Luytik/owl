package owl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import owl.models.ProductForSale;
import owl.services.ProductForSaleService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/upload")
public class UploadController {

    private final String IMAGEFOLDER = "./src/main/upload/images/";
    private final ProductForSaleService productForSaleService;

    @Autowired
    public UploadController(ProductForSaleService productForSaleService) {
        this.productForSaleService = productForSaleService;
    }

    @GetMapping
    public String uploadGoodsForm(){
        return "uploadGoods";
    }

    @PostMapping
    public String uploadGoodsToDB(Model model, @RequestParam("image")MultipartFile image,
                                  @RequestParam("name") String name, @RequestParam("shortDesc") String shortDesc,
                                  @RequestParam("longDesc") String longDesc, @RequestParam("price") String price) {
        
        ProductForSale productForSale = new ProductForSale(name, shortDesc, longDesc, price, image.getOriginalFilename());
        productForSaleService.addProduct(productForSale);
        try {
            uploadImageToFolder(image, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("msg", "Uploaded images: " + image.getOriginalFilename());
        return "uploadGoods";
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
