package tn.esprit.springboot.service;

import java.util.List;

import tn.esprit.springboot.entity.Category;
import tn.esprit.springboot.entity.Product;

public interface ICategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    void updateCategory(Category category, int idCategory);
    void deleteCategoryById(int id);
    int getNbrCategories();




}
