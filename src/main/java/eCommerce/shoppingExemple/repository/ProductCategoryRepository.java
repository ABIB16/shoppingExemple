package eCommerce.shoppingExemple.repository;

import eCommerce.shoppingExemple.Model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {

    Optional<ProductCategory> findByName(String name);
}
