package eCommerce.shoppingExemple.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product_item")
@Data
@NoArgsConstructor
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    @ManyToOne( fetch = FetchType.LAZY)
    private Product product;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne( fetch = FetchType.LAZY)
    private Customer customer;
    private Integer quantity;
    private double totalPrice;

    public ProductItem(Product product, Integer quantity, double totalPrice) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
