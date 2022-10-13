package owl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import owl.dto.ProductsForSaleDTOFromForm;
import owl.models.ProductForSale;
import owl.services.FromCyrillicToLatin;
import owl.services.ProductForSaleService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/upload")
public class UploadController {

    private final String IMAGEFOLDER = "./src/main/upload/images/products/";
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
    public String uploadProductsToDB(@ModelAttribute ProductsForSaleDTOFromForm productsForSaleDTOfromForm ) {

        ProductForSale productForSale = productForSaleService.FromFormToProduct(productsForSaleDTOfromForm);
        String folderName = FromCyrillicToLatin.transliterate(productsForSaleDTOfromForm.getName());
        try {
            //Upload mainImage to ProductName folder, Image name "1"
            uploadImageToFolder(productsForSaleDTOfromForm.getMainImage(), folderName, "1");
            //Upload additional images to ProductName folder, image names 2,3,4...
            for(int i = 0; i < productsForSaleDTOfromForm.getAdditionalImages().length; i++){
                uploadImageToFolder(productsForSaleDTOfromForm.getAdditionalImages()[i],
                        folderName, String.valueOf(i + 2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*ProductForSale productForSale = productForSaleService.converterFromDTO(productsForSaleDTOfromForm);
        productForSaleService.addProduct(productForSale);
        *//*try {
            uploadImageToFolder(productsForSaleDTOfromForm.getImage(), productForSale.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return "uploadGoods";
    }

    private void uploadImageToFolder(MultipartFile image, String folderName, String imageName) throws IOException{
        StringBuilder folderPath = new StringBuilder(IMAGEFOLDER);
        folderPath.append(folderName);
        File folderForProductImage = new File(folderPath.toString());
        folderForProductImage.mkdir();
        Path pathToImage = Paths.get(folderForProductImage.toString(), image.getOriginalFilename());
        Files.write(pathToImage, image.getBytes());
    }
}
