package tn.esprit.springboot.controller;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.stripe.model.Charge;

import http.PaymentIntentDto;
import http.PaymentIntentDto.Currency;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import tn.esprit.springboot.entity.Bill;
import tn.esprit.springboot.entity.PaymentType;
import tn.esprit.springboot.service.IBillService;
import tn.esprit.springboot.service.PaymentService;
import tn.esprit.springboot.utils.BillPdfExporter;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("bill")
public class BillController {
	
	@Autowired
	private IBillService billService;
	@Autowired
	private PaymentService paymentservice;
	
	// http://localhost:8083/springmvc/bill/add-bill
		@PostMapping("/add-bill")
		@ResponseBody
		public Bill addBill(@RequestBody Bill b) {
		Bill bill = billService.addBill(b);
		return bill;
		}
	
	// URL : http://localhost:8083/springmvc/bill/getAllBill
    @GetMapping(value = "getAllBill")
	  
	    public List<Bill> getAllBill(){
		return billService.getAllBill();
		}
	    
	 // URL : http://localhost:8083/springmvc/bill/delete-bill



		   @DeleteMapping(value = "delete-bill/{idBill}")
		   
			public void deleteBill(@PathVariable("idBill")Long idBill){
			   billService.deleteBill(idBill);
		   }
		   
		// http://localhost:8083/springmvc/bill/modify-bill



			@PutMapping("/modify-bill")
			@ResponseBody
			public Bill modifyBill(@RequestBody Bill bill) {
			return billService.updateBill(bill);
			}
			
			//@PreAuthorize("hasAuthority('ADMINISTRATOR') or hasAuthority('CLIENT') or hasAuthority('DELIVERYPERSON')")
			
					  // @GetMapping("/showPDF/{idBill}")
					   
						 //  public void billpdf (@PathVariable("idBill") Long idBill) {
						   							// billService.billpdf(idBill); }

			@PostMapping("/checkout/{idBill}")
			@ResponseBody
			public Charge checkout (@RequestHeader("stripe-token") String token ,@PathVariable("idBill")Long idBill) throws Exception{
				Bill bill =this.billService.getbillByid(idBill);
				if (!bill.getPaymentType().equals(PaymentType.By_Card) ) {
					throw new RuntimeException("payment type should be by card");
				}
					
				 PaymentIntentDto  paymentIntentDto =new PaymentIntentDto();
				 paymentIntentDto.setAmount(bill.getMontant());
				 paymentIntentDto.setCurrency( PaymentIntentDto.Currency.eur);
				 
				 Charge charge=paymentservice.chargeCreditCard(token, paymentIntentDto);
				 bill.setPayed(true);
				this.billService.updateBill(bill);
				 return charge;
			}


	@GetMapping("/pdf/{idBill}")
	@ResponseBody
	public ResponseEntity<StreamingResponseBody> getPDF (@PathVariable("idBill")Long idBill) {
		Bill bill = this.billService.getbillByid(idBill);
		BillPdfExporter billPdfExporter = new BillPdfExporter(Collections.singletonList(bill));
		StreamingResponseBody body = outputStream -> {
			try {
				billPdfExporter.export(outputStream);
			} catch (DocumentException e) {
				throw new RuntimeException(e);
			}
		};
		return new ResponseEntity<>(body, HttpStatus.OK);
	}

}
