package tn.esprit.springboot.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name = "Product")
public class Product implements Serializable {
    public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdprod() {
		return idprod;
	}
	public void setIdprod(int idprod) {
		this.idprod = idprod;
	}
	public String getNameprod() {
		return nameprod;
	}
	public void setNameprod(String nameprod) {
		this.nameprod = nameprod;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBarcodeprod() {
		return barcodeprod;
	}
	public void setBarcodeprod(String barcodeprod) {
		this.barcodeprod = barcodeprod;
	}
	public String getImageFileNameProduct() {
		return imageFileNameProduct;
	}
	public void setImageFileNameProduct(String imageFileNameProduct) {
		this.imageFileNameProduct = imageFileNameProduct;
	}
	public String getWeightprod() {
		return weightprod;
	}
	public void setWeightprod(String weightprod) {
		this.weightprod = weightprod;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Ads> getAds() {
		return ads;
	}
	public void setAds(List<Ads> ads) {
		this.ads = ads;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idprod;
    private String nameprod;
    private double price;
    private String barcodeprod;
    private String imageFileNameProduct;
    private String weightprod;

    @ManyToOne
   private Category category;
    @OneToMany
    private List<Ads> ads;

}
