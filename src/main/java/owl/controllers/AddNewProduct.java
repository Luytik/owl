package owl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import owl.dto.ProductsForSaleDTOFromForm;
import owl.models.ProductForSale;
import owl.services.ProductForSaleService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/upload")
public class AddNewProduct {

    private final String IMAGEFOLDER = "./src/main/upload/images/products/";
    private final ProductForSaleService productForSaleService;

    @Autowired
    public AddNewProduct(ProductForSaleService productForSaleService) {
        this.productForSaleService = productForSaleService;
    }

    @GetMapping
    public String uploadGoodsForm() {
        return "uploadGoods";
    }

    @PostMapping
    public String uploadProductsToDB(@ModelAttribute ProductsForSaleDTOFromForm productsForSaleDTOfromForm) {
        ProductForSale productForSale = productForSaleService.FromFormToProduct(productsForSaleDTOfromForm);
        String folderName = productForSale.getCyrillicName();
        try {
            //Upload mainImage to ProductName folder, Image name "1"
            if (!productsForSaleDTOfromForm.getMainImage().isEmpty()) {
                uploadImageToFolder(productsForSaleDTOfromForm.getMainImage(), folderName, "1");
            }
            //Upload additional images to ProductName folder, image names 2,3,4...
            for (int i = 0; i < productsForSaleDTOfromForm.getAdditionalImages().length; i++) {
                if (productsForSaleDTOfromForm.getAdditionalImages()[i].getOriginalFilename().equals(
                        productsForSaleDTOfromForm.getMainImage().getOriginalFilename())) {
                    continue;
                }
                if(productsForSaleDTOfromForm.getAdditionalImages()[i].isEmpty())
                    continue;
                uploadImageToFolder(productsForSaleDTOfromForm.getAdditionalImages()[i],
                        folderName, String.valueOf(i + 2));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        productForSaleService.addProduct(productForSale);

        return "uploadGoods";
    }

    private void uploadImageToFolder(MultipartFile image, String folderName, String imageName) throws IOException {
        StringBuilder folderPath = new StringBuilder(IMAGEFOLDER);
        folderPath.append(folderName);
        File folderForProductImage = new File(folderPath.toString());
        folderForProductImage.mkdir();
        Path pathToImage = Paths.get(folderForProductImage.toString(), imageName + "." +
                image.getOriginalFilename().split("\\.")[1]);
        Files.write(pathToImage, image.getBytes());
    }
}
