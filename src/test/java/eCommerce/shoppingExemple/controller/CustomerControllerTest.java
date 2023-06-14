package eCommerce.shoppingExemple.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import eCommerce.shoppingExemple.service.CustomerService;
import eCommerce.shoppingExemple.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CustomerService customerServiceMock;

    @Autowired
    private ObjectMapper objectMapper;
}
