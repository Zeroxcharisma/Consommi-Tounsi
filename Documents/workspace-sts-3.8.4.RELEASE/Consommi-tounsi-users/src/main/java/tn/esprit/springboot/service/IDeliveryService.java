package tn.esprit.springboot.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.springboot.entity.Delivery;

public interface IDeliveryService {
	
	List<Delivery>retreiveAllDelivery();
	Delivery addDelivery(Delivery dd);
	void deleteDelivery(int id);
	Delivery updateDelivery(Delivery dd);
	Optional<Delivery>retreiveDelivery(int id);
	
	

}
