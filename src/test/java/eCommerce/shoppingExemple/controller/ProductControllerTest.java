package eCommerce.shoppingExemple.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import eCommerce.shoppingExemple.Model.Product;
import eCommerce.shoppingExemple.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ProductService productServiceMock;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void findByNameTest() throws Exception {
        Optional<Product> testProduct = Optional.of(new Product("Nouveau Produit", 4000, 2));
        Mockito.when(productServiceMock.findByName("Nouveau Produit")).thenReturn(testProduct);
        String name = "test";
        mockMvc.perform(get("/products/name/{name}", name)
                        .contentType("application/json"))
				        .andExpect(status().isOk());
    }

    @Test
    public void createProductTest() throws Exception {
        Product testProduct = new Product("Nouveau Produit", 222, 22);
        Mockito.when(productServiceMock.saveProduct(Mockito.any(Product.class))).thenReturn(testProduct);
        mockMvc.perform(post("/products")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(testProduct)))
                        .andExpect(status().isOk());
    }

}
