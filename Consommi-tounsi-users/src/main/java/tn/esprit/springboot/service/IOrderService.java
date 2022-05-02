package tn.esprit.springboot.service;

import java.util.List;


import tn.esprit.springboot.entity.Order;


public interface IOrderService {

	Order addOrder(Order o);

	Order updateOrder(Order o);

	void deleteOrder(Long idOrder);

	List<Order> getAllOrder();
Order getOrderById(long idOrder);
List<Order>findUnlinkedOrders();


	
}

