
package tn.esprit.spring.repository;
import tn.esprit.spring.entity.Department;

import tn.esprit.spring.entity.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.PathVariable;



public interface ProductRepository extends CrudRepository<Product, Integer>  {
	
public Product findByTitleProduct(String name);
public Optional<Product> findBytitleProduct(String titleProduct);

}



