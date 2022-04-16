package tn.esprit.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.springboot.entity.Delivery;
import tn.esprit.springboot.entity.User;


import tn.esprit.springboot.repository.IDeliveryRepository;
import tn.esprit.springboot.repository.UserRepository;

@Service
public class DeliveryServiceImpl implements IDeliveryService {

	@Autowired
	UserRepository userR;
	@Autowired
	IDeliveryRepository deliveryR;




	@Override
	public List<Delivery>retreiveAllDelivery(){
		
		List<Delivery> delivery = (List <Delivery>)deliveryR.findAll();
		return delivery;
	}
	
	@Override
	public Delivery addDelivery(Delivery dd){
		
		return deliveryR.save(dd);
	}
	
	@Override
	public void deleteDelivery(int id) {
		
		deliveryR.deleteById(id);
	}
	
	@Override
	public Delivery updateDelivery(Delivery dd) {
		
		return deliveryR.save(dd);
		}
	
	@Override
	public Optional<Delivery> retreiveDelivery(int id) {
		
		return deliveryR.findById(id);
	}

	
	}


