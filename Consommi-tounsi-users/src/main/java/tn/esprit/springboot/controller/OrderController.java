package tn.esprit.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.springboot.entity.Order;
import tn.esprit.springboot.repository.UserRepository;
import tn.esprit.springboot.repository.OrderRepository;
import tn.esprit.springboot.service.IOrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	UserRepository ur;
	OrderRepository or;
	
	// http://localhost:8083/springmvc/order/add-order
	
	@PostMapping("/add-order")
	@ResponseBody
	public Order addOrder(@RequestBody Order o) {
	Order order = orderService.addOrder(o);
	return order;
	}
	
	// http://localhost:8083/springmvc/order/modify-order


				@PutMapping("/modify-order")
				@ResponseBody
				public Order updateOrder(@RequestBody Order o) {
				return orderService.updateOrder(o);
				}
				
				 
				

				 
	
	// URL : http://localhost:8083/springmvc/order/delete-order


				 @DeleteMapping(value = "delete-order/{idOrder}")
				   
				public void deleteOrder(@PathVariable("idOrder")Long idOrder){
					   orderService.deleteOrder(idOrder);
				   }
	
	
	// URL : http://localhost:8083/springmvc/order/getAllOrder

				@GetMapping(value = "getAllOrder")
				  
				public List<Order> getAllOrder(){
				return orderService.getAllOrder();
					}
				@GetMapping(value = "/getOrderById/{idOrder}")
				@ResponseBody
				public Order getOrderById(@PathVariable("idOrder") long idOrder) {
					return orderService.getOrderById(idOrder);
				}
				@GetMapping(value = "getUnlinkedOrders")
				@ResponseBody
				public List<Order> findUnlinkedOrders(){
					return this.orderService.findUnlinkedOrders();
					
				}
				
}
