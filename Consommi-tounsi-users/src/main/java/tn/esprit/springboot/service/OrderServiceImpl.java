package tn.esprit.springboot.service;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.springboot.entity.Order;


import tn.esprit.springboot.repository.OrderRepository;


@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	
	@Override
	public Order addOrder(Order o) {
		// TODO Auto-generated method stub
		return orderRepository.save(o);
		
	}
	
	
	@Override

	public Order updateOrder(Order o) {
		if (o.getIdOrder()==null){
		throw new  RuntimeException("order not nul");
	}
		this.orderRepository.findById(o.getIdOrder()).orElseThrow(()->new RuntimeException("order not found"));
		
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
	public Order getOrderById(long idOrder) {
		return orderRepository.findById(idOrder).get();
	}
	public List<Order> findUnlinkedOrders(){
		return this.orderRepository.findByBillIsNull();
		
	}

}
	




