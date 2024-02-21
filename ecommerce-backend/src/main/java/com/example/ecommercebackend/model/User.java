package com.example.ecommercebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private Long id;
	
	@Column(name="username",nullable = false,unique = true)
	private String username;

	@JsonIgnore
	@Column(name="password",nullable = false,length =1000)
	private String password;
	
	@Column(name="email",nullable = false)
	private String email;
	
	@Column(name="firstname",nullable = false)
	private String firstname;
	
	@Column(name="lastname",nullable = false)
	private String lastname;
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE, orphanRemoval = true)
	List<Address> addresses=new ArrayList<>();

	public List<Address> getAddresses() {
		return addresses;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
	
}
