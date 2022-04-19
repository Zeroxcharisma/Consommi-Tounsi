package tn.esprit.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity  //thelek tableau fl base d données ala esm l classe(mapping objet relationel)

public class Ads implements Serializable {

    public Ads() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idAd;
    private String channelAd;

    public int getIdAd() {
		return idAd;
	}

	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}

	public String getChannelAd() {
		return channelAd;
	}

	public void setChannelAd(String channelAd) {
		this.channelAd = channelAd;
	}

	public Date getDateBeginAd() {
		return dateBeginAd;
	}

	public void setDateBeginAd(Date dateBeginAd) {
		this.dateBeginAd = dateBeginAd;
	}

	public Date getDateEndAd() {
		return dateEndAd;
	}

	public void setDateEndAd(Date dateEndAd) {
		this.dateEndAd = dateEndAd;
	}

	public int getNbrInitialViewsAd() {
		return nbrInitialViewsAd;
	}

	public void setNbrInitialViewsAd(int nbrInitialViewsAd) {
		this.nbrInitialViewsAd = nbrInitialViewsAd;
	}

	public int getNbrFinalViewsAd() {
		return nbrFinalViewsAd;
	}

	public void setNbrFinalViewsAd(int nbrFinalViewsAd) {
		this.nbrFinalViewsAd = nbrFinalViewsAd;
	}

	public float getPriceAd() {
		return priceAd;
	}

	public void setPriceAd(float priceAd) {
		this.priceAd = priceAd;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "yyyy-MM-dd")
    private Date dateBeginAd;

    @Temporal(TemporalType.DATE)
    private Date dateEndAd;
    private int nbrInitialViewsAd;
    private int nbrFinalViewsAd;

    private float priceAd;

    @ManyToOne
    @JoinColumn(name = "fkIdProd")
    private Product product;

}

