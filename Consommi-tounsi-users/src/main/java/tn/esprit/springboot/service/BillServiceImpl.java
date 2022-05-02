package tn.esprit.springboot.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.springboot.entity.Bill;
import tn.esprit.springboot.repository.BillRepository;




@Service
public class BillServiceImpl implements IBillService {
	
	@Autowired
	private BillRepository billRepository;
	
	
	
	@Override
	public Bill addBill(Bill b) {
		// TODO Auto-generated method stub
		return billRepository.save(b);
		
	}

	@Override
	public List<Bill> getAllBill() {
		return (List<Bill>)billRepository.findAll();
	}
	
	@Override
	public void deleteBill(Long idBill) {
		billRepository.deleteById(idBill);
		
	}
	
	@Override
	public Bill updateBill(Bill b) {
		
			this.billRepository.findById(b.getIdBill()).orElseThrow(()->new RuntimeException("order not found"));
		
		return billRepository.save(b);
	}
	public Bill getbillByid(long idBill) {
		
		return this.billRepository.findById(idBill).orElseThrow(()->new RuntimeException("bill not found"));
	
	
}


	

}


