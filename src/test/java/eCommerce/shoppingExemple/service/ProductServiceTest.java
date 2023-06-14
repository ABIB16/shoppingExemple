package eCommerce.shoppingExemple.service;

import eCommerce.shoppingExemple.Model.Product;
import eCommerce.shoppingExemple.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.context.support.ResourceBundleThemeSource;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    /*@Test
    void findByEmailNotFound(){
        Optional<Product> product= productService.findByName("Produit inconnu");
        assertEquals (false,product.isPresent());
    }

    @Test
    void findByEmailFound(){
        Optional<Product> product= productService.findByName("Produit 1");
        assertEquals (true,product.isPresent());
    }*/



    @Test
    public void findByNameTest() {
        Optional<Product> autherParam = Optional.of(new Product("Nouveau Produit", 4000, 2));
        Mockito.when(productRepository.findByName(Mockito.anyString())).thenReturn(autherParam);
        Optional<Product> auther = productService.findByName("test");
        assertEquals(true, auther.isPresent());
        assertEquals("Nouveau Produit", auther.get().getName());
    }
}
