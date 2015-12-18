package com.consultorio.core.dataaccess.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.untitled.dataaccess.entity.BaseEntity;

@Entity
@Table(name = "treatment")
public class Treatment extends BaseEntity{
	@Id
	@Column(name = "treatment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Drug drug;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Disease disease;
	
	@Column(name = "description", length = 500)
	private String description;

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
