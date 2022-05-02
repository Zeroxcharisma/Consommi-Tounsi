package tn.esprit.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Entity
@Table (name = "Bill")
public class Bill implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idBill ;
	@Column(name = "montant")
	private double montant;
	@Temporal (TemporalType.DATE)
	@Column(name = "dateBill")
	private Date dateBill ;
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	@Column(name = "isPayed")
	private boolean isPayed=false;
	


	public boolean isPayed() {
		return isPayed;
	}

	public void setPayed(boolean isPayed) {
		this.isPayed = isPayed;
	}

	@OneToOne(cascade = CascadeType.REMOVE)
	private Order order;

	public long getIdBill() {
		return idBill;
	}

	public void setIdBill(long idBill) {
		this.idBill = idBill;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDateBill() {
		return dateBill;
	}

	public void setDateBill(Date dateBill) {
		this.dateBill = dateBill;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	public Bill() {
		super();
	}

	public Bill(long idBill, double montant, Date dateBill, PaymentType paymentType,Order order,boolean  isPayed) {
		super();
		this.idBill = idBill;
		this.montant = montant;
		this.dateBill = dateBill;
		this.paymentType = paymentType;
		this.order = order;
		this.isPayed= isPayed;
	}


}