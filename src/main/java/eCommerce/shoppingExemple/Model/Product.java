package eCommerce.shoppingExemple.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table (name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private Integer quantityInStock;
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductCategory category;

    public Product(String name, double price, Integer quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

}
