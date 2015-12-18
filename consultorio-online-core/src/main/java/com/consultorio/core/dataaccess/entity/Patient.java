package com.consultorio.core.dataaccess.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.untitled.dataaccess.entity.BaseEntity;

@Entity
@Table(name = "patient")
public class Patient extends BaseEntity {

	@Id
	@Column(name = "patient_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", length = 500)
	private String name;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private BloodType bloodType;

	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "job")
	private String job;

	@Column(name = "limitations")
	private String limitations;

	@Column(name = "education_level")
	private String educationLevel;

	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable( name="patient_address",
	    joinColumns = @JoinColumn( name="patient_id"),
	    inverseJoinColumns = @JoinColumn( name="address_id"))
	private Address address;

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "hereditary_family_background_id")
	private HeredoFamilyBackground hereditaryFamilyBackground;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the bloodType
	 */
	public BloodType getBloodType() {
		return bloodType;
	}

	/**
	 * @param bloodType
	 *            the bloodType to set
	 */
	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	/**
	 * @return the maritalStatus
	 */
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus
	 *            the maritalStatus to set
	 */
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the limitations
	 */
	public String getLimitations() {
		return limitations;
	}

	/**
	 * @param limitations
	 *            the limitations to set
	 */
	public void setLimitations(String limitations) {
		this.limitations = limitations;
	}

	/**
	 * @return the educationLevel
	 */
	public String getEducationLevel() {
		return educationLevel;
	}

	/**
	 * @param educationLevel
	 *            the educationLevel to set
	 */
	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the hereditaryFamilyBackground
	 */
	public HeredoFamilyBackground getHereditaryFamilyBackground() {
		return hereditaryFamilyBackground;
	}

	/**
	 * @param hereditaryFamilyBackground
	 *            the hereditaryFamilyBackground to set
	 */
	public void setHereditaryFamilyBackground(HeredoFamilyBackground hereditaryFamilyBackground) {
		this.hereditaryFamilyBackground = hereditaryFamilyBackground;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
