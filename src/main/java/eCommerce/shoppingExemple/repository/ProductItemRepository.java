package eCommerce.shoppingExemple.repository;

import eCommerce.shoppingExemple.Model.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemRepository  extends JpaRepository<ProductItem,Long> {
}
