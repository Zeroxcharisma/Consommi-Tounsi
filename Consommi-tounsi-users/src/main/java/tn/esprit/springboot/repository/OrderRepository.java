package tn.esprit.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import tn.esprit.springboot.entity.Order;


@Repository
public interface OrderRepository extends CrudRepository <Order,Long> {
	
	List<Order> findByBillIsNull();

}

