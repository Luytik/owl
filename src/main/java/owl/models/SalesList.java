package owl.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class SalesList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    private String description;
    @Column(nullable = false)
    private Double price;
    private Double selfPrice;
    private String pathToPicture;

    @OneToMany(mappedBy = "salesList")
    private List<Orders> orders;

    public void setPictureAsJSON(File file) throws IOException {
        if(file.exists()){
            byte[] arrayByte;
            arrayByte = Files.readAllBytes(file.toPath());
            String s = Base64.getEncoder().encodeToString(arrayByte);
            StringBuilder sb = new StringBuilder();
            sb.append("-file" + " " + file.getName() + " " + s);
            pathToPicture = sb.toString();
        } else {
            System.out.println("Link to the file s incorrected");
        }
    }


}
