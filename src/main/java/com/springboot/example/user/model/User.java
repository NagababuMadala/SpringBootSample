package com.springboot.example.user.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -7351729135012380019L;

	@Id
	private int userId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "address")
	private String address;
	
	public User() {}	
	
	public User(int userId, String password, String contact, String address) {
		this.userId = userId;
		this.password = password;
		this.contact = contact;
		this.address = address;
	}
	
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User[" + userId + " " + password + " " + contact + " " + address + "]";
	}	
	
	

}
