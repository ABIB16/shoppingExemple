package eCommerce.shoppingExemple.service;

import eCommerce.shoppingExemple.Model.Customer;
import eCommerce.shoppingExemple.Model.Product;
import eCommerce.shoppingExemple.Model.ProductCategory;
import eCommerce.shoppingExemple.Model.ProductItem;
import eCommerce.shoppingExemple.repository.CustomerRepository;
import eCommerce.shoppingExemple.repository.ProductCategoryRepository;
import eCommerce.shoppingExemple.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    ProductRepository productRepository;

    @Mock
    ProductCategoryRepository productCategoryRepository;

    @Mock
    CustomerRepository customerRepository;

    @Test
    public void addProductItemToCustomer(){
        ProductCategory cat = new ProductCategory(1L,"Nouvelle catégorie");
        Product product = new Product(1L,"Nouveau Produit", 3000, 60,cat);
        Integer quantityExist =5;
        Integer quantityToAdd = 3;
        double totalPrice = 15000;
        ProductItem item = new ProductItem(product, quantityExist,totalPrice);
        List<ProductItem> itemList = new ArrayList<>();
        itemList.add(item);
        Customer customer = new Customer(1L,"first name","last name","adresse",itemList);

        Mockito.when(productCategoryRepository.findById(cat.getId())).thenReturn(Optional.of(cat));
        Mockito.when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        Mockito.when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));
        customerService.addProductItemToCustomer(customer.getId(),product.getId(),quantityToAdd);

        // vérifier l'existance de la catégotir
        assertEquals(cat, item.getProduct().getCategory());

        // vérifier l'existance du produit
        assertEquals(product, item.getProduct());

        // vérifer la mise à jour de la quantité
        assertEquals(quantityExist + quantityToAdd , item.getQuantity());

        // vérifer la mise à jour du montant total
        assertEquals(product.getPrice() * item.getQuantity() , item.getTotalPrice());

        // vérifier l'enregistrement
        verify(customerRepository).save(customer);

    }



}
