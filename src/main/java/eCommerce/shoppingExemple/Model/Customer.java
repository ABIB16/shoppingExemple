package eCommerce.shoppingExemple.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    @OneToMany( mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ProductItem> productItemList = new ArrayList<>();

}
