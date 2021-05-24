package com.example.demo.model;

//import java.util.ArrayList;
//import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "profile_pic_link")
	private String profilePicLink;
	
	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "contact_detail")
	private String contactDetail;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "certification")
	private String certification;
	
	@Column(name = "ewallet")
	private float ewallet;
	
	public Customer() {
		
	}

	public Customer(String profilePicLink, String nickname, String password, String contactDetail, String phone, String email, String address, String certification, float ewallet) {
		// super();
		this.profilePicLink = profilePicLink;
		this.nickname = nickname;
		this.password = password;
		this.contactDetail = contactDetail;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.certification = certification;
		this.ewallet = ewallet;	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfilePicLink() {
		return profilePicLink;
	}

	public void setProfilePicLink(String profilePicLink) {
		this.profilePicLink = profilePicLink;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(String contactDetail) {
		this.contactDetail = contactDetail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public float getEwallet() {
		return ewallet;
	}

	public void setEwallet(float ewallet) {
		this.ewallet = ewallet;
	}
}