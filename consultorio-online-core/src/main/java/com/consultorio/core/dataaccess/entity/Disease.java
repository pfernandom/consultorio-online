package com.consultorio.core.dataaccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.untitled.dataaccess.entity.BaseEntity;

@Entity
@Table(name = "disease")
public class Disease extends BaseEntity {
	@Id
	@Column(name = "disease_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "code", length = 50)
	private String code;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "description", length = 500)
	private String description;

	@Column(name = "type", length = 50)
	private String type;

	@Column(name = "is_congenital")
	private Boolean congenital;

	@Column(name = "is_chronic_degenerative")
	private Boolean chronicDegenerative;

	@Column(name = "is_infectious")
	private Boolean infectious;

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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the congenital
	 */
	public Boolean isCongenital() {
		return congenital;
	}

	/**
	 * @param congenital
	 *            the congenital to set
	 */
	public void setCongenital(Boolean congenital) {
		this.congenital = congenital;
	}

	/**
	 * @return the chronicDegenerative
	 */
	public Boolean isChronicDegenerative() {
		return chronicDegenerative;
	}

	/**
	 * @param chronicDegenerative
	 *            the chronicDegenerative to set
	 */
	public void setChronicDegenerative(Boolean chronicDegenerative) {
		this.chronicDegenerative = chronicDegenerative;
	}

	/**
	 * @return the infectious
	 */
	public Boolean isInfectious() {
		return infectious;
	}

	/**
	 * @param infectious
	 *            the infectious to set
	 */
	public void setInfectious(Boolean infectious) {
		this.infectious = infectious;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
