package eCommerce.shoppingExemple.config;

import eCommerce.shoppingExemple.Model.Customer;
import eCommerce.shoppingExemple.Model.Product;
import eCommerce.shoppingExemple.Model.ProductCategory;
import eCommerce.shoppingExemple.Model.ProductItem;
import eCommerce.shoppingExemple.service.CustomerService;
import eCommerce.shoppingExemple.service.ProductCategoryService;
import eCommerce.shoppingExemple.service.ProductItemService;
import eCommerce.shoppingExemple.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class StartData implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public void run(String... args) throws Exception {

        if (productCategoryService.findAll().isEmpty()) {
            // create product category
            ProductCategory cat1 = new ProductCategory();
            cat1.setName("Produits cosmetiques");

            ProductCategory cat2 = new ProductCategory();
            cat2.setName("produit vestimentaire");

            ProductCategory cat3 = new ProductCategory();
            cat3.setName("electromenager");

            ProductCategory cat4 = new ProductCategory();
            cat4.setName("meubles");

            ProductCategory cat5 = new ProductCategory();
            cat5.setName("Fruits et légumes");

            productCategoryService.insertAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5));
        }

        if (productService.findAll().isEmpty()) {
            // create product
            Product product1 = new Product();
            product1.setName("Produit 1");
            product1.setPrice(1000);
            product1.setQuantityInStock(10);
            product1.setCategory(productCategoryService.findById(1L));

            Product product2 = new Product();
            product2.setName("Produit 2");
            product2.setPrice(2000);
            product2.setQuantityInStock(20);
            product2.setCategory(productCategoryService.findById(2L));

            Product product3 = new Product();
            product3.setName("Produit 3");
            product3.setPrice(3000);
            product3.setQuantityInStock(30);
            product3.setCategory(productCategoryService.findById(3L));

            productService.insertAll(Arrays.asList(product1,product2,product3));
        }

        if (customerService.findAll().isEmpty()) {

            Customer customer1 = new Customer();
            customer1.setFirstName("ABIB");
            customer1.setLastName("Billel");
            customer1.setAddress("ALGER");

            // add first product item to customer
            ProductItem item1 = new ProductItem();
            item1.setCustomer(customer1);
            item1.setProduct(productService.findById(1L));
            item1.setQuantity(2);
            item1.setTotalPrice(productService.findById(1L).getPrice() * item1.getQuantity());

            // add second product item to customer
            ProductItem item2 = new ProductItem();
            item2.setCustomer(customer1);
            item2.setProduct(productService.findById(2L));
            item2.setQuantity(3);
            item2.setTotalPrice(productService.findById(2L).getPrice() * item2.getQuantity());

            customer1.getProductItemList().addAll(Arrays.asList(item1,item2));
            customerService.saveCustomer(customer1);
        }
    }

}
