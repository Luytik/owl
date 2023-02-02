package owl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import owl.dto.ProductsForSaleDTOFromForm;
import owl.models.ProductForSale;
import owl.models.SecondaryImageNames;
import owl.services.ProductForSaleService;
import owl.services.SecondaryImageNamesService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/product/addnew")
public class AddNewProduct {

    private final String IMAGEFOLDER = "./src/main/upload/images/products/";
    private final ProductForSaleService productForSaleService;
    private final SecondaryImageNamesService secondaryImageNamesService;

    @Autowired
    public AddNewProduct(ProductForSaleService productForSaleService,
                            SecondaryImageNamesService secondaryImageNamesService) {
        this.productForSaleService = productForSaleService;
        this.secondaryImageNamesService = secondaryImageNamesService;
    }

    @GetMapping
    public String uploadGoodsForm() {
        return "uploadGoods";
    }

    @PostMapping
    public String uploadProductsToDB(@ModelAttribute ProductsForSaleDTOFromForm productsForSaleDTOfromForm) {
        ProductForSale productForSale = productForSaleService.FromFormToProduct(productsForSaleDTOfromForm);
        String folderName = productForSale.getCyrillicName();
        List<SecondaryImageNames> additionalImageNames = new ArrayList<>();
        try {
            //Upload mainImage to ProductName folder, Image name original filename
            if (!productsForSaleDTOfromForm.getMainImage().isEmpty()) {
                uploadImageToFolder(productsForSaleDTOfromForm.getMainImage(), folderName,
                     productsForSaleDTOfromForm.getMainImage().getOriginalFilename());
                     productForSale.setMainImageName(productsForSaleDTOfromForm
                     .getMainImage().getOriginalFilename());
            }
            //Upload additional images to ProductName folder, image names original filenames
            for (int i = 0; i < productsForSaleDTOfromForm.getAdditionalImages().length; i++) {
                if(productsForSaleDTOfromForm.getAdditionalImages()[i].isEmpty())
                    continue;
                if (productsForSaleDTOfromForm.getAdditionalImages()[i].getOriginalFilename().equals(
                        productsForSaleDTOfromForm.getMainImage().getOriginalFilename())) {
                    continue;
                }
                uploadImageToFolder(productsForSaleDTOfromForm.getAdditionalImages()[i],
                        folderName, productsForSaleDTOfromForm.getAdditionalImages()[i].getOriginalFilename());
                        SecondaryImageNames additionalImageName = new SecondaryImageNames(productsForSaleDTOfromForm.getAdditionalImages()[i]
                                                .getOriginalFilename());
                additionalImageNames.add(additionalImageName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        productForSale.setSecondaryImageNames(additionalImageNames);
        productForSaleService.addProduct(productForSale);
        for(SecondaryImageNames name : additionalImageNames){
            name.setProductForSale(productForSale);
        }
        secondaryImageNamesService.addImageNames(additionalImageNames);

        
        
        return "uploadGoods";
    }

    private void uploadImageToFolder(MultipartFile image, String folderName, String imageName) throws IOException {
        StringBuilder folderPath = new StringBuilder(IMAGEFOLDER);
        folderPath.append(folderName);
        File folderForProductImage = new File(folderPath.toString());
        folderForProductImage.mkdirs();
        Path pathToImage = Paths.get(folderForProductImage.toString(), imageName);
        Files.write(pathToImage, image.getBytes());
    }
}
