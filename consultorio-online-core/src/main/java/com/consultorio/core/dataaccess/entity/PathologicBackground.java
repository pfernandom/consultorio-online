package com.consultorio.core.dataaccess.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.untitled.dataaccess.entity.BaseEntity;

@Entity
@Table(name = "pathologic_background")
public class PathologicBackground extends BaseEntity{

	
	@Id
	@Column(name = "pathologic_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	@JoinTable( name="alergie_pathologic",
            joinColumns = @JoinColumn( name="pathologic_id"),
            inverseJoinColumns = @JoinColumn( name="alergy_id"))
	private List<Alergy> alergies;
	
	@OneToMany
	@JoinTable( name="adiction_pathologic",
            joinColumns = @JoinColumn( name="pathologic_id"),
            inverseJoinColumns = @JoinColumn( name="addiction_id"))
	private List<Addiction> addictions;
	
	@OneToMany
	@JoinTable( name="personaldisease_pathologic",
            joinColumns = @JoinColumn( name="pathologic_id"),
            inverseJoinColumns = @JoinColumn( name="disease_id"))
	private List<Disease> diseases;
	
	
	@OneToMany
	@JoinTable( name="quirurgical_pathologic",
            joinColumns = @JoinColumn( name="pathologic_id"),
            inverseJoinColumns = @JoinColumn( name="quirurgical_id"))
	private List<QuirurgicalProcedure> quirurgicalProcedures;
	
	@OneToMany
	@JoinTable( name="trauma_pathologic",
            joinColumns = @JoinColumn( name="pathologic_id"),
            inverseJoinColumns = @JoinColumn( name="trauma_id"))
	private List<Trauma> traumas;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Treatment treatment;

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
	 * @return the alergies
	 */
	public List<Alergy> getAlergies() {
		return alergies;
	}

	/**
	 * @param alergies the alergies to set
	 */
	public void setAlergies(List<Alergy> alergies) {
		this.alergies = alergies;
	}

	/**
	 * @return the addictions
	 */
	public List<Addiction> getAddictions() {
		return addictions;
	}

	/**
	 * @param addictions the addictions to set
	 */
	public void setAddictions(List<Addiction> addictions) {
		this.addictions = addictions;
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

	/**
	 * @return the quirurgicalProcedures
	 */
	public List<QuirurgicalProcedure> getQuirurgicalProcedures() {
		return quirurgicalProcedures;
	}

	/**
	 * @param quirurgicalProcedures the quirurgicalProcedures to set
	 */
	public void setQuirurgicalProcedures(List<QuirurgicalProcedure> quirurgicalProcedures) {
		this.quirurgicalProcedures = quirurgicalProcedures;
	}

	/**
	 * @return the traumas
	 */
	public List<Trauma> getTraumas() {
		return traumas;
	}

	/**
	 * @param traumas the traumas to set
	 */
	public void setTraumas(List<Trauma> traumas) {
		this.traumas = traumas;
	}
	
	
}
