package tn.esprit.springboot.controller;

import java.util.List;
import java.util.Optional;

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

import tn.esprit.springboot.entity.Delivery;


import tn.esprit.springboot.service.IDeliveryService;


@RestController
@RequestMapping("/api/v1")
public class DeliveryRestControlIer{
	
	
	@Autowired
	IDeliveryService deliveryS;
	
	// http://localhost:8083/springmvc/api/v1/addDelivery
	@PostMapping("/addDelivery")
	@ResponseBody
	public Delivery addDeliveryPerson(@RequestBody Delivery d) {
		deliveryS.addDelivery(d);
	return d;
	}
	
	// http://localhost:8083/springmvc/api/v1/retrievealldelivery
	
		@GetMapping("/retrievealldelivery")
		@ResponseBody
		public List<Delivery> getDelivery() {
		List<Delivery> list = deliveryS.retreiveAllDelivery();
		return list;
		}
		
		// http://localhost:8083/springmvc/api/v1/retrievedelivery/{Delivery-id}
		
		@GetMapping("/retrievedelivery/{Delivery-id}")
		@ResponseBody
		public Optional<Delivery>retrieveDeliveryPerson(@PathVariable("Delivery-id") int idDelivery ) {
		return deliveryS.retreiveDelivery(idDelivery );
		}
		
		
		// http://localhost:8083/springmvc/api/v1/remove-delivery/{Delivery-id}
		
		@DeleteMapping("/remove-delivery/{Delivery-id}")
		@ResponseBody
		public void removeDelivery(@PathVariable("Delivery-id") int idDelivery) {
		deliveryS.deleteDelivery(idDelivery);
		}
		
		
		// http://localhost:9091/SpringMVC/servlet/modify-delivery
		
		@PutMapping("/modify-delivery")
		@ResponseBody
		public Delivery modifyDelivery(@RequestBody Delivery d) {
		return deliveryS.updateDelivery(d);
	}
		
		
					
		}
		
		