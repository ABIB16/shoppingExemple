package eCommerce.shoppingExemple.service;

import eCommerce.shoppingExemple.Model.ProductCategory;
import eCommerce.shoppingExemple.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    public ProductCategory findById(Long id) {
        ProductCategory  productCat = productCategoryRepository.findById(id).orElseThrow(()-> new RuntimeException("product category not found"));
        return productCat;
    }

    public ProductCategory insert(ProductCategory cat) {
        return productCategoryRepository.save(cat);
    }

    public List<ProductCategory> insertAll(List<ProductCategory> entity) {
        return productCategoryRepository.saveAll(entity);
    }

}
