package owl.models;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
public class Client {
    @Id
    private Long id;

    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private String country;
    private String city;
    @OneToMany(mappedBy = "client")
    private List<Orders> orders;
}
