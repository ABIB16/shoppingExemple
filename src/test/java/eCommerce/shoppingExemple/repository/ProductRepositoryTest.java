package eCommerce.shoppingExemple.repository;

import eCommerce.shoppingExemple.Model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void findByEmailTest(){
        Optional<Product> product= productRepository.findByName("Produit 1");
        assertEquals (true,product.isPresent());
    }
}
