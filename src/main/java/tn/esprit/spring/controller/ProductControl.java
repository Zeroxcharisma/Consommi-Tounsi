
 package tn.esprit.spring.controller;
import tn.esprit.spring.service.IProductService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



import ch.qos.logback.core.Context;
import http.Mensaje;
import io.netty.handler.ipfilter.IpSubnetFilter;
import tn.esprit.spring.ResourceNotFoundException.ResourceNotFoundException;
import tn.esprit.spring.entity.Articulo;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.UnderCategory;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.repository.UnderCategoryRepository;
import tn.esprit.spring.response.Response;


@CrossOrigin
@RestController



public class ProductControl {
	@Autowired
	IProductService productService;
	@Autowired
	ServletContext context;
	@Autowired
	UnderCategoryRepository ucr;
	@Autowired
	ProductRepository pr;


  //CRUUUUUD
	//POST
	//http://localhost:9091/SpringMVC/servlet/add-product/{iduc}/{idDep}
//	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
	@PostMapping("/add-product/{iduc}/{idDep}")
	@ResponseBody
	public Product addProduct(@RequestBody Product p,@PathVariable("iduc")int iduc,@PathVariable("idDep")int idDep)
	{
		Product prod = productService.addProduct(p,iduc,idDep);
		return prod;
	}

//////////////////////////////////////////////////////////////////////
	/////////////////
//////////SAVEEEE PRODUCT WITH IMAGE
	//http://localhost:9091/SpringMVC/servlet/add-product/Productss
	@PostMapping("/Productss")
	public ResponseEntity<Response> createProduct (@RequestParam("file") MultipartFile file,int id,
												   @RequestParam("article") String product) throws JsonParseException , JsonMappingException , Exception
	{
		System.out.println("Ok .............");
		Product prod = new ObjectMapper().readValue(product, Product.class);
		UnderCategory uc=ucr.findById(id).get();
		prod.setUnderCategory(uc);

		boolean isExit = new File(context.getRealPath("/Images/")).exists();
		if (!isExit)
		{
			new File (context.getRealPath("/Images/")).mkdir();
			System.out.println("mk dir.............");
		}
		String filename = file.getOriginalFilename();
		String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
		File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
		try
		{
			System.out.println("Image");
			FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
		}catch(Exception e) {
			e.printStackTrace();
		}
		prod.setFileName(newFileName);
		Product art = pr.save(prod);
		if (art != null)
		{
			return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Response>(new Response ("Article not saved"),HttpStatus.BAD_REQUEST);
		}
	}



	//GET

	//http://localhost:9091/SpringMVC/servlet/show-all-products
	@GetMapping("/show-all-products")
	@ResponseBody
	public List<Product> getAllProducts()
	{
		List <Product> list=productService.showAll();
		return list;
	}

	////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

	@GetMapping("/lista")
	public ResponseEntity<List<Product>> lista(){
		List<Product> lista = productService.lista();
		return new ResponseEntity<List<Product>>(lista, HttpStatus.OK);
	}
//////////////////////////////////////////////////////////////////////




	//http://localhost:9091/SpringMVC/servlet/GetByOneName/{productName}
	@GetMapping("/GetByOneName/{productName}")
	@ResponseBody
	public Product RetrieveByName(@PathVariable("productName")String nameProd)
	{
		return productService.GetByName(nameProd);
	}
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	// http://localhost:9091/SpringMVC/servlet/Imgarticles/{id}
	@GetMapping(path="/Imgarticles/{id}")
	public byte[] getPhoto(@PathVariable("id") int id) throws Exception{
		Product prod  = pr.findById(id).get();
		return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+prod.getFileName()));
	}

	///////////////////?????????????????????????????????????????/
	///////////////////?????????????????????????????????????????/
	///////////////////?????????????????????????????????????????/
	///////////////////?????????????????????????????????????????/


	@GetMapping("/detalle/{idProduct}")
	public ResponseEntity<Product> detalle(@PathVariable("idProduct") int idProduct){
		if(!productService.existsId(idProduct))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Product product = productService.getById(idProduct).get();
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}


	//PUT
	//http://localhost:9091/SpringMVC/servlet/update-Product/{id}
//	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
	@PutMapping("/update-Product/{id}")
	@ResponseBody
	public Product updateProduct(@PathVariable(value = "id") int id,@RequestBody Product p)
	{
		return productService.updateProduct(id, p);
	}

	//DELETE
	//http://localhost:9091/SpringMVC/servlet/remove-product/{productId}
//	@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('DEPARTMENTMANAGER')")
	@DeleteMapping("/remove-product/{productId}")
	@ResponseBody
	public void removeProduct(@PathVariable("productId") int id)
	{
		productService.deleteProduct(id);
	}
	////////////////////////////////////
	@DeleteMapping("/products/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") int prodId)
			throws ResourceNotFoundException {
		Product product = pr.findById(prodId)
				.orElseThrow(() -> new ResourceNotFoundException("Article not found  id :: " + prodId));
		pr.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}



	//LES METIERS-LES AFFECTATIONS
  }
