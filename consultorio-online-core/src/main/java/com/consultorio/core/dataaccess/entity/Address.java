package com.consultorio.core.dataaccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.untitled.dataaccess.entity.BaseEntity;

@Entity
@Table(name = "address")
public final class Address extends BaseEntity{
	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "street", length = 500)
	private String street;
	@Column(name = "city", length = 500)
	private String city;
	@Column(name = "state", length = 500)
	private String state;
	@Column(name = "zip", length = 500)
	private String zip;
	
	public Address(){
		
	}
	
	/** Create an address with street, city, state, and zip */
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/** Return street */
	public String getStreet() {
		return street;
	}

	/** Return city */
	public String getCity() {
		return city;
	}

	/** Return state */
	public String getState() {
		return state;
	}

	/** Return zip */
	public String getZip() {
		return zip;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	

}