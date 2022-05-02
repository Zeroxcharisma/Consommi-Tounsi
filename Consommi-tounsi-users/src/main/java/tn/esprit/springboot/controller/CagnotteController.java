package tn.esprit.springboot.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.springboot.entity.Cagnotte;
import tn.esprit.springboot.repository.CagnotteRepository;
import tn.esprit.springboot.service.ICagnotteService;


@RestController
@RequestMapping("cagnotte")
public class CagnotteController {
	
	@Autowired
	private ICagnotteService cagnotteService;
	
	@Autowired
	CagnotteRepository cr;
	@Autowired
	ServletContext context;
	
	// http://localhost:8083/springmvc/cagnotte/add-cagnotte

		@PostMapping("/add-cagnotte")
		@ResponseBody
		public Cagnotte addCagnotte(@RequestBody Cagnotte c) {
		Cagnotte cagnotte = cagnotteService.addCagnotte(c);
		return cagnotte;
		}
	
	// URL : http://localhost:8083/springmvc/cagnotte/getAllCagnotte

		@GetMapping(value = "getAllCagnotte")

	    public List<Cagnotte> getAllCagnotte(){
		return cagnotteService.getAllCagnotte();
		}
	    
	 // URL : http://localhost:8083/springmvc/cagnotte/delete-cagnotte
		   @DeleteMapping(value = "delete-cagnotte/{idCagnotte}")
			public void deleteCagnotte(@PathVariable("idCagnotte")int idCagnotte){
			   cagnotteService.deleteCagnotte(idCagnotte);
		   }
		   
		// http://localhost:8083/springmvc/cagnotte/modify-cagnotte
			@PutMapping("/modify-cagnotte")

			@ResponseBody
			public Cagnotte modifyCagnotte(@RequestBody Cagnotte cagnotte) {
			return cagnotteService.updateCagnotte(cagnotte);
			}
			
		// URL : http://localhost:8083/springmvc/cagnotte/getCagnotte_by_ID
			 @GetMapping(value = "getCagnotte_by_ID/{idCagnotte}")


			 public Optional<Cagnotte> getCagnotte_by_ID(@PathVariable("idCagnotte")int idCagnotte) {
					return cagnotteService.getCagnotte_by_ID(idCagnotte);
			}
			 
			 
}

