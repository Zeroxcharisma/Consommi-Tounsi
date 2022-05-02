package tn.esprit.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties
@Entity
@Table(name="T_ORDER")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrder ;
	@Temporal (TemporalType.DATE)
	private Date dateOrder ;
	private int productNumberOrder ;
	private String stateOrder ;
	private float amountOrder ;
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	@OneToOne(mappedBy="order" ,cascade = CascadeType.ALL)
	@JsonIgnore
	private Bill bill;
	@ManyToOne
	User user;
	
	
	

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public int getProductNumberOrder() {
		return productNumberOrder;
	}

	public void setProductNumberOrder(int productNumberOrder) {
		this.productNumberOrder = productNumberOrder;
	}

	public String getStateOrder() {
		return stateOrder;
	}

	public void setStateOrder(String stateOrder) {
		this.stateOrder = stateOrder;
	}

	public float getAmountOrder() {
		return amountOrder;
	}

	public void setAmountOrder(float amountOrder) {
		this.amountOrder = amountOrder;
	}

	

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	




	public Order() {
		super();
	}

	public Order(Long idOrder, Date dateOrder, int productNumberOrder, String stateOrder, float amountOrder,
			PaymentType paymentType) {
		super();
		this.idOrder = idOrder;
		this.dateOrder = dateOrder;
		this.productNumberOrder = productNumberOrder;
		this.stateOrder = stateOrder;
		this.amountOrder = amountOrder;
		this.paymentType = paymentType;
		
	}
	


	
}
