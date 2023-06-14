package eCommerce.shoppingExemple.service;

import eCommerce.shoppingExemple.Model.Customer;
import eCommerce.shoppingExemple.Model.Product;
import eCommerce.shoppingExemple.Model.ProductCategory;
import eCommerce.shoppingExemple.Model.ProductItem;
import eCommerce.shoppingExemple.exceptions.EntityNotFoundExecption;
import eCommerce.shoppingExemple.repository.CustomerRepository;
import eCommerce.shoppingExemple.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private MessageSource messageSource;

    Logger log = LoggerFactory.getLogger(CustomerService.class);

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void addProductItemToCustomer(Long customerId, Long prdId, Integer quantity) {
        Optional<Product> product = productRepository.findById(prdId);
        Optional<Customer> customer = customerRepository.findById(customerId);

        if (product.isPresent() && customer.isPresent()) {

            // si le produit existe encore dans le stock
            if (product.get().getQuantityInStock() > quantity) {

                Optional<ProductItem> itemExist = customer.get().getProductItemList().stream().filter(productItem -> productItem.getProduct().equals(product.get())).findFirst();

                // si le produit existe deja dans la liste
                if (itemExist.isPresent()) {
                    ProductItem p = itemExist.get();
                    itemExist.get().setQuantity(p.getQuantity() + quantity);
                    itemExist.get().setTotalPrice(p.getQuantity() * product.get().getPrice());
                } else {
                    // ajouter le nouveau produit dans la liste
                    ProductItem newItem = new ProductItem();
                    newItem.setCustomer(customer.get());
                    newItem.setQuantity(quantity);
                    newItem.setTotalPrice(quantity * product.get().getPrice());
                    newItem.setProduct(product.get());
                    customer.get().getProductItemList().add(newItem);
                }
                // mettre à jour la quantité restante
                product.get().setQuantityInStock(product.get().getQuantityInStock() - quantity);
                productRepository.save(product.get());
                saveCustomer(customer.get());
            } else {
                log.error("stock epuisé");
            }
        } else {
            throw new EntityNotFoundExecption("Product or customer is null");
        }
    }


}
