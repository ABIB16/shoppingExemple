package eCommerce.shoppingExemple.service;


import eCommerce.shoppingExemple.Model.Customer;
import eCommerce.shoppingExemple.Model.Product;
import eCommerce.shoppingExemple.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Product  product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
        return product;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


    public List<Product> insertAll(List<Product> entity) {
        return productRepository.saveAll(entity);
    }

    public Optional<Product> findByName(String name){
        return  productRepository.findByName(name);
    }
}
