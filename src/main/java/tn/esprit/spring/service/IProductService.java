
package tn.esprit.spring.service;
import java.util.List;

import java.util.Optional;

import tn.esprit.spring.entity.Product;




public interface IProductService {
	
	
	public List<Product> showAll();
	public void deleteProduct(int id);
	public Product updateProduct(int id,Product p);
	public Product addProduct(Product p,int id,int idDepartmet);
	public Product GetByName(String nameProduct);
	public List<Product> lista();
	public boolean existsId(int idProduct);
	public Optional<Product> getById(int idProduct);
	public void save(Product product);

	};

