

package tn.esprit.springboot.service;

import java.util.List;

import tn.esprit.springboot.entity.Order;
import tn.esprit.springboot.entity.PaymentType;

public interface IOrderService {
	
	Order addOrder(Order o);

	Order updateOrder(Order o);

	void deleteOrder(Long idOrder);

	List<Order> getAllOrder();

	List<Order> getOrder_by_Type(PaymentType paymentType);

}
