package tn.esprit.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.GenericTableMetaDataProvider;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.springboot.entity.Product;
import tn.esprit.springboot.service.ICategoryService;
import tn.esprit.springboot.service.IProductService;
import tn.esprit.springboot.service.ProductService;

@RestController
@RequestMapping("/product")

public class ProductController {

    //the controller will talk to the service list to we need to add service

    @Autowired
    private IProductService service;

    @Autowired
    private ICategoryService iCategoryService;

    //post method ok
    @PostMapping ("/addproduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
	/*@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products){
		return service.saveproducts(products);
	}*/

    //ok
    @GetMapping("/products")
    public List<Product> findAllProducts()
    {
        return service.getAllProducts();

    }


    //ok
    @PutMapping(value = "/updateProduct/{idprod}")
    public void updateProduct(@RequestBody Product product, @PathVariable int idprod) {
        service.updateProduct(product, idprod);
    }
    
    //ok
    @DeleteMapping("/deleteProductById/{idprod}")
	public void deleteProductById(@PathVariable("idprod") int idprod) {
		service.deleteProductById(idprod);

	}
    
    //ok
    @GetMapping("/getprodbyid/{idprod}")
    public Product findProductById(@PathVariable int idprod)
    {
        return service.getProductById(idprod);
    }
    //ok
    @GetMapping("/getprodbyname/{nameprod}")
    public Product findProductByName(@PathVariable String nameprod)
    {
        return service.getProductByName(nameprod);
    }
    
    //OK
    @GetMapping(value = "/recherche/{prod}")
	public List<Product> recherche(@PathVariable("prod") String nameprod) {

		return service.recherche(nameprod);
	}


    //ERROR*********

		@PutMapping(value = "/affectProductToCategory/{idProduct}/{idCategory}")
		public void affectProductToCategory(@PathVariable("idprod") int idprod, @PathVariable("idcat") int idcat) {
			service.affectProductToCategory(idprod, idcat);
		}

    // Counting products
    	//ok
		@GetMapping(value = "/getNbrProds")
		public long getNbProds() {
			return service.getNbrProducts();
		}

    public ICategoryService getiCategoryService() {
        return iCategoryService;
    }

    public void setiCategoryService(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }
}

