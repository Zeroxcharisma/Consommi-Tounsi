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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.springboot.repository.UserRepository;
import tn.esprit.springboot.entity.Order;
import tn.esprit.springboot.repository.IOrderRepository;
import tn.esprit.springboot.service.IOrderService;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	UserRepository ur;
	IOrderRepository or;
	
	@PostMapping("/add-order")
	@ResponseBody
	public Order addOrder(@RequestBody Order o) {
	Order order = orderService.addOrder(o);
	return order;
	}
	
	@PutMapping("/modify-order")
	@ResponseBody
	public Order updateOrder(@RequestBody Order o) {
	return orderService.updateOrder(o);
	}
	
	 @DeleteMapping(value = "delete-order/{idOrder}")
	   
		public void deleteOrder(@PathVariable("idOrder")Long idOrder){
			   orderService.deleteOrder(idOrder);
		   }

		@GetMapping(value = "getAllOrder")
		  
		public List<Order> getAllOrder(){
		return orderService.getAllOrder();
			}

}
