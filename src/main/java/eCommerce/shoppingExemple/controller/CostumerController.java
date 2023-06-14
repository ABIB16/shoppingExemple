package eCommerce.shoppingExemple.controller;

import eCommerce.shoppingExemple.Model.Customer;
import eCommerce.shoppingExemple.Model.Product;
import eCommerce.shoppingExemple.Model.ProductItem;
import eCommerce.shoppingExemple.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CostumerController {

    private final CustomerService customerService ;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/{customerId}/{productId}")
    public void addItemToCustomerList(@PathVariable Long customerId,@PathVariable Long productId, @RequestBody ProductItem item, @RequestParam Integer quantity) {
        customerService.addProductItemToCustomer(customerId, productId,quantity);
    }
}
