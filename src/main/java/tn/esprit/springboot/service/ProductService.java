package tn.esprit.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springboot.entity.Category;
import tn.esprit.springboot.entity.Product;
import tn.esprit.springboot.repository.CategoryRepository;
import tn.esprit.springboot.repository.ProductRepository;


@Service
public class ProductService implements IProductService

{
    @Autowired
    private ProductRepository productrepository;
    
    @Autowired 
    private CategoryRepository categoryrepository;


    //take the argument as product object and save it
    //postmethod
    public Product saveProduct(Product product)
    {
        return productrepository.save(product);
    }


    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productrepository.findAll();
    }


    @Override
    public Product getProductById(int idprod) {
        return productrepository.findById(idprod).get();
    }


    @Override
    public Product getProductByName(String nameprod) {
        return productrepository.findByNameprod(nameprod);
    }
    @Override
    public void updateProduct(Product prod, int idprod) {
        if (productrepository.findById(idprod).orElse(null) != null)
            prod.setIdprod(idprod);


        productrepository.save(prod);

    }


    @Override
    public void deleteProductById(int idprod) {
        productrepository.deleteById(idprod);

    }


	@Override
	public void affectProductToCategory(int idprod, int idcat) {
		Product productEntity = productrepository.findById(idprod).get();
		Category category = categoryrepository.findById(idprod).get();

		productEntity.setCategory(category);
		productrepository.save(productEntity);

	}

 


	@Override
	public long getNbrProducts() {
		return this.productrepository.count();
	}


	@Override
	public List<Product> recherche(String nameprod) {
		return this.productrepository.findByNameprodLike(nameprod);
	
	}
    



}


