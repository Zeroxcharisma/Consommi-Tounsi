package tn.esprit.springboot.service;

import java.util.List;

import tn.esprit.springboot.entity.Product;

public interface IProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int idprod);
    void deleteProductById(int idprod);
    Product getProductByName(String nameprod);
    void updateProduct(Product prod, int idprod);
    public void affectProductToCategory(int idprod, int idcat);
    //List<Product> saveproducts(List<Product> products);
   long getNbrProducts();
   List<Product> recherche(String keyword);
    


}
