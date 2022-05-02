package tn.esprit.springboot.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.springboot.entity.Bill;




@Repository
public interface BillRepository  extends CrudRepository <Bill,Long> {
	//@Query(value = "SELECT * FROM BILL WHERE id_bill=?1", nativeQuery = true)
	//public Bill getOne(Long idBill);
	

	
}