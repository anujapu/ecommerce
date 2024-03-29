package com.example.ecommercebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false)
	private Long id;

	@Column(name="addressLine1",nullable = false,length = 512)
	private String addressLine1;

	@Column(name="addressLine2",length = 512)
	private String addressLine2;

	@Column(name="city",nullable = false)
	private String city;

	@Column(name="country",nullable = false,length = 75)
	private String country;

	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id",nullable = false)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Address{" +
				"id=" + id +
				", addressLine1='" + addressLine1 + '\'' +
				", addressLine2='" + addressLine2 + '\'' +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				'}';
	}
}
