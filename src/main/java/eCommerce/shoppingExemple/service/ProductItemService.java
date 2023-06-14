package eCommerce.shoppingExemple.service;

import eCommerce.shoppingExemple.Model.Customer;
import eCommerce.shoppingExemple.Model.ProductItem;
import eCommerce.shoppingExemple.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductItemService {

    @Autowired
    ProductItemRepository productItemRepository;
    public List<ProductItem> findAll() {
        return productItemRepository.findAll();
    }
}
