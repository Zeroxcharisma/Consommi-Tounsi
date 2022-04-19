package tn.esprit.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.springboot.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

//  @Query("select p from Product p where p.idprod =:idprod")
    Product findByNameprod(String nameprod);


    //@Query("select nameprod from Product where nameprod like :keyword")
    //List<String> search(String keyword);


    
    
    List<Product> findByNameprodLike(String nameprod);
    

    
    
      



}


