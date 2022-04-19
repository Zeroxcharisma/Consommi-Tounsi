package tn.esprit.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.springboot.entity.Order;
import tn.esprit.springboot.entity.PaymentType;
//import tn.esprit.springboot.repository.BillRepository;

import tn.esprit.springboot.repository.IOrderRepository;


@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderRepository orderRepository;

	//private BillRepository billRepository;

	
	
	@Override
	public Order addOrder(Order o) {
		// TODO Auto-generated method stub
		return orderRepository.save(o);
		
	}
	
	@Override

	public Order updateOrder(Order o) {
		
		return orderRepository.save(o);
	}
	
	@Override
	public void deleteOrder(Long idOrder) {
		orderRepository.deleteById(idOrder);
		
	}
	
	@Override
	public List<Order> getAllOrder() {
		return (List<Order>)orderRepository.findAll();
	}
	
	@Override
	 public List<Order> getOrder_by_Type(PaymentType paymentType){
	    return orderRepository.findByPaymentType(paymentType);
	 }
	


}
	




