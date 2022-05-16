
package tn.esprit.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.el.parser.ParseException;

import tn.esprit.spring.ResourceNotFoundException.ResourceNotFoundException;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.repository.PublicityRepository;
import tn.esprit.spring.response.Response;
import tn.esprit.spring.service.IPublicityService;
import tn.esprit.spring.service.PublicityServiceImpl;
@RestController
@CrossOrigin
public class PublicityControl {
	
	@Autowired
	IPublicityService PS;

	@Autowired
	PublicityServiceImpl PublicityServiceImpl;
	@Autowired
	PublicityRepository pr;
	@Autowired
	ServletContext context;

	/////////CRUUUUUUD
	//POST

	//http://localhost:9091/SpringMVC/servlet/add-publicity
//	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PostMapping("/add-publicity")
	@ResponseBody
	public Publicity addPublicity(@RequestBody Publicity pub)
	{
		Publicity publicty = PS.addPublicity(pub);
		return publicty;
	}

////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
	@PostMapping("/PostPubImage")
	public ResponseEntity<Response> createProduct (@RequestParam("file") MultipartFile file,
												   @RequestParam("article") String product) throws JsonParseException ,
			JsonMappingException , Exception
	{
		System.out.println("Ok .............");
		Publicity prod = new ObjectMapper().readValue(product, Publicity.class);
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
		Publicity art = pr.save(prod);
		if (art != null)
		{
			return new ResponseEntity<Response>(new Response ("Added With Image Success "),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Response>(new Response ("Article not saved"),HttpStatus.BAD_REQUEST);
		}
	}

	////////////////////////////////////////////////
	////////////////////////////////////////////////

	//GET
	//http://localhost:9091/SpringMVC/servlet/show-all-publicities
	@GetMapping("/show-all-publicities")
	@ResponseBody
	public List<Publicity> getAllPubs(){
		List <Publicity> list=PS.showAll();
		return list;
	}

/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
	//http://localhost:9091/SpringMVC/servlet/GETALLPUBLICITIES
	@GetMapping("/GETALLPUBLICITIES")
	public List<Publicity> getAllPublicities(){
		System.out.println(" getAllPublicities ...");
		List<Publicity>publicities=new ArrayList<>();
		pr.findAll().forEach(publicities :: add);
		return publicities;
	}
	/////////////////////////////////////
	/////////////////////////////////////
//
	@GetMapping(path="/ImgPublcities/{id}")
	public byte[] getPhoto(@PathVariable("id") int id) throws Exception
	{
		Publicity pub  = pr.findById(id).get();
		return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+pub.getFileName()));
	}
///////////////////////////////////////////////
///////////////////////////////////////////////
	//http://localhost:9091/SpringMVC/servlet/publ/{id}
	@GetMapping("/publ/{id}")
	public ResponseEntity<Publicity> getArticleById(@PathVariable(value = "id") int Id)
			throws ResourceNotFoundException
	{
		Publicity pub = pr.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Categorie not found for this id :: " + Id));
		return ResponseEntity.ok().body(pub);
	}
////////////////////////////////////////////////////////
////////////////////////////////////////////////////////


	//http://localhost:9091/SpringMVC/servlet/get-by-Name-all-publicities-by-name/{PubName}
	@GetMapping("/get-by-Name-all-publicities-by-name/{PubName}")
	@ResponseBody
	public List<Publicity> RetrieveByName(@PathVariable("PubName")String namePub){
		return PS.GetPublicitiesByName(namePub);
	}
/////////////////////////////////////////////////
/////////////////////////////////////////////////
	//http://localhost:9091/SpringMVC/servlet/get-by-id-publicity/{publicityId}
	@GetMapping("get-by-id-publicity/{publicityId}")
	@ResponseBody
	public Publicity RetrieveById(@PathVariable("publicityId")int id)
	{
		return PS.GetPublicityById(id);
	}


	//PUT
	//http://localhost:9091/SpringMVC/servlet/update-publicity
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PutMapping("/update-publicity/{Idpublicity")
	@ResponseBody
	public Publicity updatepublicity(@PathVariable(value ="Idpublicity") int Idpublicity,@RequestBody Publicity pub)
	{
		return PS.updatePublicity(Idpublicity,pub);
	}





	//DELETE
	//http://localhost:9091/SpringMVC/servlet/remove-publicity/{pubId}
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@DeleteMapping("/remove-publicity/{pubId}")
	@ResponseBody
	public void removePublicity(@PathVariable("pubId") int id)
	{
		PS.deletePublicity(id);
	}


	/////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////
	//http://localhost:9091/SpringMVC/servlet/publiciiiity/{id}
	@DeleteMapping("/publiciiiity/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") int pubId)
			throws ResourceNotFoundException
	{
		Publicity p = pr.findById(pubId)
				.orElseThrow(() -> new ResourceNotFoundException("Article not found  id :: " + pubId));
		pr.delete(p);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}



/////METIERS-



//
////	http://localhost:9091/SpringMVC/servlet/CalculateTotalCost/{Canal}/{Sdate}/{Fdate}/{Tpub}
//	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
//	@PostMapping("/CalculateTotalCost/{Canal}/{Sdate}/{Fdate}/{Tpub}")
//	public float CalculateTotalCost(@PathVariable(value = "Canal") String canal,@PathVariable(value = "Sdate") String dateDebut,
//			@PathVariable(value = "Fdate")String dateFin,@PathVariable(value = "Tpub") String typePub) throws ParseException
//	{
//		return PublicityServiceImpl.CalculeCoutTotalPub(canal, dateDebut, dateFin, typePub);
//	}

	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////

////	http://localhost:9091/SpringMVC/servlet/costOnNbrDays/{Sdate}/{Fdate}
//	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
//	@PostMapping("/costOnNbrDays/{Sdate}/{Fdate}")
//	public float costOnNbrDays(@PathVariable(value = "Sdate") String dateDebut,
//			@PathVariable(value = "Fdate")String dateFin) throws ParseException {
//		return PublicityServiceImpl.costOnNbrDays(dateDebut, dateFin);
//	}

}
