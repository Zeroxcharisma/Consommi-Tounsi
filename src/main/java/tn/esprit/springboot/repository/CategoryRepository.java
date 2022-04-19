package tn.esprit.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.springboot.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

    @Query("select count(c.nameCategory) from Category c")
    int getNbCategories();

}
