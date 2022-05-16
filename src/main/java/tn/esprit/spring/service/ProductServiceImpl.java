
package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.DepartmentRepository;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.repository.UnderCategoryRepository;
import tn.esprit.spring.entity.Department;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.UnderCategory;



@Service
public class ProductServiceImpl implements IProductService { //implementation==> hibernate

	@Autowired
	ProductRepository productRepository;
	@Autowired
	UnderCategoryRepository ucr;
	@Autowired
	DepartmentRepository dr;

	

	
	@Override
	public List<Product> showAll() {
		List<Product> products =(List<Product>) productRepository.findAll();
		return products;
	}

	@Override
	public Product GetByName(String nameProduct)
	{
		return productRepository.findByTitleProduct(nameProduct);
	}

	@Override  
	public Product addProduct(Product p,int id,int idDepratment) {
		
		UnderCategory undercat=ucr.findById(id).get();
		p.setUnderCategory(undercat);
		
		Department dep=dr.findById(idDepratment).get();
		p.setIdDepartment(dep);

		
		productRepository.save(p);
		return p;
	}

	@Override
	public void deleteProduct(int id) {
		if (productRepository.existsById(id))
		{
		productRepository.deleteById(id);
		}
		else System.out.println("Product with id:"+id+" Not exist");
	}

 


	@Override
	public Product updateProduct(int id,Product p) {
		
		Product oldprod=productRepository.findById(id).get();
		oldprod.setTitleProduct(p.getTitleProduct());
		oldprod.setDescriptionProduct(p.getDescriptionProduct());
		oldprod.setQuantityProduct(p.getQuantityProduct());
		oldprod.setPriceProduct(p.getPriceProduct());
		oldprod.setWeightProduct(p.getWeightProduct());
		oldprod.setBuyingPriceProduct(p.getBuyingPriceProduct());
		oldprod.setMaxQuantityProduct(p.getMaxQuantityProduct());
	
		return productRepository.save(oldprod);
	
	}



		public List<Product> lista(){
	        List<Product> lista = (List<Product>) productRepository.findAll();
	        return lista;
	    }

	    public Optional<Product> getById(int idProduct){
	        return productRepository.findById(idProduct);
	    }

	    public Optional<Product> getByTitle(String titleProduct){
	        return productRepository.findBytitleProduct(titleProduct);
	    }

	    public void save(Product product){
	        productRepository.save(product);
	    }

	    public void delete(int idProduct){
	        productRepository.deleteById(idProduct);
	    }

	    public boolean existsId(int idProduct){
	        return productRepository.existsById(idProduct);
	    }

}

