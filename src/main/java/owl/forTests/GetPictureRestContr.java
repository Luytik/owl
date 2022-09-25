package owl.forTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import owl.models.ProductForSale;
import owl.services.ProductForSaleService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/getpicture", produces = MediaType.IMAGE_PNG_VALUE)
public class GetPictureRestContr {

    private final ProductForSaleService productForSaleService;

    @Autowired
    public GetPictureRestContr(ProductForSaleService productForSaleService) {
        this.productForSaleService = productForSaleService;
    }

    @GetMapping("/{id}")
    public void getImage(HttpServletResponse response, @PathVariable(value = "id")  long id){
        var productForSale = productForSaleService.getProductById(id);
        var imageFile = new ClassPathResource(productForSale.get().getMainPictureUrl());
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        try {
            StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
