package eCommerce.shoppingExemple.controller;

import eCommerce.shoppingExemple.Model.Product;
import eCommerce.shoppingExemple.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        Product product = productService.findByName(name).get();
        return ResponseEntity.ok(product);
    }
}
