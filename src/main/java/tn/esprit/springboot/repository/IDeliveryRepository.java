package tn.esprit.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.springboot.entity.Delivery;

@Repository
public interface IDeliveryRepository extends CrudRepository<Delivery,Integer>{
	
}