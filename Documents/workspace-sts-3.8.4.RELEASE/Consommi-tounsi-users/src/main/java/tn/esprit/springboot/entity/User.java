package tn.esprit.springboot.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table (name= "User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	protected int idUser ;
	@Column(name = "username")
	protected String username ;
	@Column(name = "lastNameUser")
	protected String lastNameUser ;
	@Column(name = "cinUser")
	protected String cinUser ;
	@Column(name = "password")
	protected String password ;
	@Column(name = "confirmPasswordUser")
	protected String confirmPasswordUser ;
	@Column(name = "stateUser")
	protected boolean stateUser ;
	@Column(name = "salaire")
	protected float salaire;
	@Column(name = "phoneNumberUser")
	protected String phoneNumberUser ;
	@Column(name = "adressUser")
	protected String adressUser ;
	@Column(name = "birthDateUser")
	protected Date birthDateUser ;
	@Column(name = "emailUser")
	protected String emailUser ;
	@Enumerated (EnumType.STRING)
	protected SexeType sexeUser ;
	@Enumerated (EnumType.STRING)
	private Role role;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastNameUser() {
		return lastNameUser;
	}
	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}
	public String getCinUser() {
		return cinUser;
	}
	public void setCinUser(String cinUser) {
		this.cinUser = cinUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPasswordUser() {
		return confirmPasswordUser;
	}
	public void setConfirmPasswordUser(String confirmPasswordUser) {
		this.confirmPasswordUser = confirmPasswordUser;
	}
	public boolean isStateUser() {
		return stateUser;
	}
	public void setStateUser(boolean stateUser) {
		this.stateUser = stateUser;
	}
	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	public String getPhoneNumberUser() {
		return phoneNumberUser;
	}
	public void setPhoneNumberUser(String phoneNumberUser) {
		this.phoneNumberUser = phoneNumberUser;
	}
	public String getAdressUser() {
		return adressUser;
	}
	public void setAdressUser(String adressUser) {
		this.adressUser = adressUser;
	}
	public Date getBirthDateUser() {
		return birthDateUser;
	}
	public void setBirthDateUser(Date birthDateUser) {
		this.birthDateUser = birthDateUser;
	}
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	public SexeType getSexeUser() {
		return sexeUser;
	}
	public void setSexeUser(SexeType sexeUser) {
		this.sexeUser = sexeUser;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public User(int idUser, String username, String lastNameUser, String cinUser, String password,
			String confirmPasswordUser, boolean stateUser, float salaire, String phoneNumberUser, String adressUser,
			Date birthDateUser, String emailUser, SexeType sexeUser, Role role) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.lastNameUser = lastNameUser;
		this.cinUser = cinUser;
		this.password = password;
		this.confirmPasswordUser = confirmPasswordUser;
		this.stateUser = stateUser;
		this.salaire = salaire;
		this.phoneNumberUser = phoneNumberUser;
		this.adressUser = adressUser;
		this.birthDateUser = birthDateUser;
		this.emailUser = emailUser;
		this.sexeUser = sexeUser;
		this.role = role;
	}
	public User() {
		super();
	}
	
	
	
	
	
	
}
