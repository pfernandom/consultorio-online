package com.consultorio.core.dataaccess.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "hereditary_family_background")
public class HeredoFamilyBackground {

	
	@Id
	@Column(name = "family_background_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	@JoinTable( name="disease_familybackground",
            joinColumns = @JoinColumn( name="family_background_id"),
            inverseJoinColumns = @JoinColumn( name="disease_id"))
	private List<Disease> diseases;
	
	@Column(name = "observations", length = 500)
	private String observations;

	public HeredoFamilyBackground(){
		diseases = new ArrayList<Disease>();
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
	 * @return the diseases
	 */
	public List<Disease> getDiseases() {
		return diseases;
	}

	/**
	 * @param diseases the diseases to set
	 */
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}
	
	public void addDisease(Disease disease) {
		this.diseases.add(disease);
	}

	/**
	 * @return the observations
	 */
	public String getObservations() {
		return observations;
	}

	/**
	 * @param observations the observations to set
	 */
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
