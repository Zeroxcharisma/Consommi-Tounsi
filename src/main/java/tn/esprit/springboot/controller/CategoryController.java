package tn.esprit.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.springboot.entity.Category;
import tn.esprit.springboot.service.ICategoryService;
@RequestMapping("/product")
@RestController
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category) {
        iCategoryService.addCategory(category);
        return category;
    }

    @GetMapping(value = "getCategoryById/{idCategory}")

    public Category getCategoryById(@PathVariable("idCategory") int idCategory) {
        return iCategoryService.getCategoryById(idCategory);
    }

    @GetMapping(value = "/getAllCategories")
    public List<Category> getAllCategories() {
        return iCategoryService.getAllCategories();
    }
    @PutMapping(value = "updateCategory/{idCat}")
    public void updateCategory(@RequestBody Category category, @PathVariable int idCat) {
        iCategoryService.updateCategory(category, idCat);
    }


    @DeleteMapping("/deleteCategoryById/{idcat}")

    public void deleteCategoryById(@PathVariable("idcat") int idcat) {

        iCategoryService.deleteCategoryById(idcat);

    }

}
