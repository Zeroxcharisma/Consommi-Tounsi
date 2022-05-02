package tn.esprit.springboot.service;

import java.util.List;

import tn.esprit.springboot.entity.Bill;



public interface IBillService {
	
	public List<Bill> getAllBill();

	Bill addBill(Bill b);

	void deleteBill(Long idBill);

	Bill updateBill(Bill b);
	//void billpdf(Long idBill);
	Bill getbillByid(long idBill);


}
