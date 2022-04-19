package tn.esprit.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.springboot.entity.Category;
import tn.esprit.springboot.repository.CategoryRepository;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);

    }

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();

    }

    @Override
    public Category getCategoryById(int idCategory) {
        return categoryRepository.findById(idCategory).get();

    }

    @Override
    public void updateCategory(Category category, int idCategory) {
        if (categoryRepository.findById(idCategory).orElse(null) != null)
            category.setIdCategory(idCategory);
        categoryRepository.save(category);
    }


    @Override
    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);

    }

    @Override
    public int getNbrCategories() {
        return categoryRepository.getNbCategories();
    }

}

